package dev.struchkov.example.bot.units;

import dev.struchkov.godfather.main.domain.annotation.Unit;
import dev.struchkov.godfather.main.domain.content.Mail;
import dev.struchkov.godfather.simple.domain.BoxAnswer;
import dev.struchkov.godfather.simple.domain.unit.AnswerText;
import dev.struchkov.godfather.telegram.starter.UnitConfiguration;
import org.springframework.stereotype.Component;

import static dev.struchkov.example.bot.UnitName.GENERAL_MENU;

@Component
public class GeneralMenu implements UnitConfiguration {

    @Unit(value = GENERAL_MENU, main = true)
    public AnswerText<Mail> generalMenu() {
        return AnswerText.<Mail>builder()
                .answer(BoxAnswer.boxAnswer("hello"))
                .build();
    }

}
