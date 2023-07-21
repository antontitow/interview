        org.springframework.context.ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ThreadsApplication.class);
        A a = (A) context.getBeanFactory().getBean("a");
        B b = context.getBeanFactory().getBean(B.class);
        a.voiceA();
        log.info("--------");
        b.voiceB();