package ru.titov.threads.multithreads.processors;

import lombok.extern.slf4j.Slf4j;
import ru.titov.threads.multithreads.Invoice;
import ru.titov.threads.multithreads.db.FurnitureProductFactory;
import ru.titov.threads.multithreads.products.FurnitureProduct;

import java.util.List;
import java.util.Optional;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 21.07.2023, 3:47
 **/
@Slf4j
public class FurnitureCostProccessor extends Thread {

    private volatile Invoice invoice;
    private Long productId;

    public FurnitureCostProccessor(Invoice invoice, Long productId) {
        this.invoice = invoice;
        this.productId = productId;
    }

    @Override
    public void run() {
        FurnitureProductFactory furnitureProductFactory = FurnitureProductFactory.getFurnitureProductFactory();
        List<FurnitureProduct> products = furnitureProductFactory.getProducts();
        Optional<FurnitureProduct> optionalBedProduct = products.stream().filter(pr -> pr.getId() == productId).findFirst();

        if (!optionalBedProduct.isEmpty()) {
            log.info("Находим в базе Мебели продукт {} и стоимость {} добавляем в счет", productId, optionalBedProduct.get().getCost());
            invoice.setBalance(invoice.getBalance() + optionalBedProduct.get().getCost());
        }
    }
}
