package ru.titov.threads.multithreads.processors;

import lombok.extern.slf4j.Slf4j;
import ru.titov.threads.multithreads.Invoice;
import ru.titov.threads.multithreads.db.BedProductFactory;
import ru.titov.threads.multithreads.products.BedProduct;

import java.util.List;
import java.util.Optional;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 21.07.2023, 3:41
 **/
@Slf4j
public class BedCostProccessor extends Thread {

    private volatile Invoice invoice;
    private Long productId;

    public BedCostProccessor(Invoice invoice, Long productId) {
        this.invoice = invoice;
        this.productId = productId;
    }

    @Override
    public void run() {
        BedProductFactory bedProductFactory = BedProductFactory.getBedFactory();
        List<BedProduct> products = bedProductFactory.getProducts();
        Optional<BedProduct> optionalBedProduct = products.stream().filter(pr -> pr.getId() == productId).findFirst();

        if (!optionalBedProduct.isEmpty()) {
            log.info("Находим в базе Постельное белье {} и стоимость: {} добавляем в счет", productId, optionalBedProduct.get().getCost());
            invoice.setBalance(invoice.getBalance() + optionalBedProduct.get().getCost());
        }
    }
}
