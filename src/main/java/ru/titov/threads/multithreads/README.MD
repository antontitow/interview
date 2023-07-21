        Bill bill = new Bill();
        List<Product> products = Arrays.asList(
                new FurnitureProduct(1L, null, null),
                new BedProduct(2L, null, null),
                new FurnitureProduct(3L, null, null),
                new BedProduct(4L, null, null),
                new BedProduct(1L, null, null),
                new BedProduct(2L, null, null),
                new FurnitureProduct(3L, null, null),
                new BedProduct(4L, null, null)
        );
        Order order = Order.builder().products(products).build();
        bill.processAllOrders(new Invoice(), order);

В сервис передается список id различных продуктов, которые относятся к определенной категории товаров (мебель, постельное белье);
Категории находятся в разных базах;
Нужно выбирать пакет из N продуктов, которые в отдельном потоке будут обрабатываться в рамках пула.
Поток обращается к нужной базе и находит стоимость товара, которую добавляет в счет (в перспективе добавить здесь учет накопленных бонусов)

