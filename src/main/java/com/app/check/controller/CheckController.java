package com.app.check.controller;

import com.app.check.model.Check;
import com.app.check.repo.CheckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
@Controller
@RequestMapping("/checks/")
public class CheckController {
    private final CheckRepository checkRepository;

    /**
     * Конструктор для класса CheckController, который устанавливает репозиторий для работы с данными о чеках.
     *
     * @param checkRepository Репозиторий для работы с данными в базе данных.
     */
    @Autowired
    public CheckController(CheckRepository checkRepository) {
        this.checkRepository = checkRepository;
    }

    /**
     * Отображает форму для добавления новойзаписей.
     *
     * @param check Объект, который нужно добавить.
     * @return Имя представления, которое будет отображаться.
     */
    @GetMapping("signup")
    public String showSignUpForm(Check check) {
        return "AddCheck";
    }

    /**
     * Отображает список всех записей.
     *
     * @param model Модель, которая передается в представление.
     * @return Имя представления, которое будет отображаться.
     */
    @GetMapping("list")
    public String showUpdateForm(Model model) {
        model.addAttribute("checks", checkRepository.findAll());
        return "index";
    }

    /**
     * Добавляет нового в базу данных.
     *
     * @param check Объект, который нужно добавить.
     * @param result Результаты проверки вводимых данных.
     * @param model Модель, которая передается в представление.
     * @return Имя представления, которое будет отображаться.
     */
    @PostMapping("add")
    public String addCheck(@Valid Check check, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "AddCheck";
        }

        checkRepository.save(check);
        return "redirect:list";
    }

    /**
     * Отображает форму для редактирования существующего.
     *
     * @param id Идентификатор, данные которого нужно отредактировать.
     * @param model Модель, которая передается в представление.
     * @return Имя представления, которое будет отображаться.
     */
    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Check check = checkRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Не правильный идентификатор:" + id));
        model.addAttribute("check", check);
        return "UpdateCheck";
    }

    /**
     * Обновляет данные в бд.
     *
     * @param id Идентификатор, данные которого нужно обновить.
     * @param check Объект, который нужно обновить.
     * @param result Результаты проверки вводимых данных.
     * @param model Модель, которая передается в представление.
     * @return Имя представления, которое будет отображаться.
     */
    @PostMapping("update/{id}")
    public String updateCheck(@PathVariable("id") long id, @Valid Check check, BindingResult result,
                                Model model) {
        if (result.hasErrors()) {
            check.setId(id);
            return "UpdateCheck";
        }

        checkRepository.save(check);
        model.addAttribute("checks", checkRepository.findAll());
        return "index";
    }

    /**
     * Удаляет данные из базы данных.
     *
     * @param id Идентификатор, данные которого нужно удалить.
     * @param model Модель, которая передается в представление.
     * @return Имя представления, которое будет отображаться.
     */
    @GetMapping("delete/{id}")
    public String deleteCheck(@PathVariable("id") long id, Model model) {
        Check check = checkRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Ошибка по id:" + id));
        checkRepository.delete(check);
        model.addAttribute("checks", checkRepository.findAll());
        return "index";
    }
}
