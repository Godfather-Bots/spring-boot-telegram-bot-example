package dev.struchkov.example.bot.units;

import dev.struchkov.godfather.main.domain.annotation.Unit;
import dev.struchkov.godfather.main.domain.content.Mail;
import dev.struchkov.godfather.simple.domain.unit.AnswerText;
import dev.struchkov.godfather.simple.domain.unit.MainUnit;
import dev.struchkov.godfather.telegram.starter.UnitConfiguration;
import org.springframework.stereotype.Component;

import static dev.struchkov.example.bot.UnitName.GENERAL_MENU;
import static dev.struchkov.example.bot.UnitName.HOW_ARE_YOU_ANSWER;
import static dev.struchkov.godfather.simple.domain.BoxAnswer.boxAnswer;

@Component
public class GeneralMenu implements UnitConfiguration {

    @Unit(value = GENERAL_MENU, main = true)
    public AnswerText<Mail> generalMenu(
            @Unit(HOW_ARE_YOU_ANSWER) MainUnit<Mail> howAreYouAnswer
    ) {
        return AnswerText.<Mail>builder()
                .answer(boxAnswer("Hello!"))
                .next(howAreYouAnswer)
                .build();
    }

    @Unit(HOW_ARE_YOU_ANSWER)
    public AnswerText<Mail> howAreYouAnswer() {
        return AnswerText.<Mail>builder()
                .answer(boxAnswer("I'm fine. Thank you"))
                .build();
    }

}
