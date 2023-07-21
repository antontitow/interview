        OrderHandler orderHandler = new OrderHandler(new Order(Arrays.asList(1L, 2L, 2L, 3L, 4L), 1L));
        Invoice invoice = orderHandler.orderHandle();
        log.info(invoice.toString());

Получаем список id товаров и id юзера;
Один поток подсчитывает стоимость заказа.
Второй - запрашивает в базе дисконт для клиента, если такой зарегистрирован.
Только после подсчета первого потока, второй вычисляет окончательную стоимость заказа с учетом дисконта