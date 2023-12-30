package com.app.check.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
/**
 * Класс Check представляет сущность чека со своими атрибутами и методами.
 *
 * <p>Аннотация @Entity указывает, что класс является сущностью, которая будет сохраняться в базе данных.
 * <p>Аннотация @Table(name = "checks") указывает на имя таблицы, в которой будут храниться данные.
 * <p>Аннотация @Id указывает на то, что поле id является первичным ключом сущности.
 * <p>Аннотация @GeneratedValue(strategy = GenerationType.AUTO) указывает на стратегию генерации первичного ключа.
 * <p>Аннотация @NotBlank(message = "Name is mandatory") указывает на то, что поле name не может быть пустым. *
 */
@Entity
@Table(name = "checks")
public class Check {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Name is mandatory")
    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private int price;

    @Column(name = "cassir")
    private String cassir;

    public Check() {}

    /**
     * Устанавливает ID.
     *
     * @param id ID, который нужно установить.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Возвращает ID.
     *
     * @return ID студента.
     */
    public long getId() {
        return id;
    }


    public void setPrice(int price){
        this.price = price;
    }

    public int getPrice(){
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setCassir(String cassir){
        this.cassir = cassir;
    }

    public String getCassir(){
        return cassir;
    }
}
