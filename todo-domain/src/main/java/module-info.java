module todo.modules.demo.todo.domain {
    requires spring.beans;
    requires spring.context;
    requires spring.data.commons;
    requires lombok;
    requires spring.data.relational;

    exports works.hop.todo.domain.service;
    exports works.hop.todo.domain.config;
    exports works.hop.todo.domain.repository;
    exports works.hop.todo.domain.model;
}
