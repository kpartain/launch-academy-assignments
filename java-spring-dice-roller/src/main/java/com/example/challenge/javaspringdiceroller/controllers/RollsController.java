package com.example.challenge.javaspringdiceroller.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

@Controller
@RequestMapping("/rolls")
public class RollsController {
  @GetMapping("/new")
  public String getNew(@RequestParam(required=false) int guess, Model model) throws Exception {
    String yourGuess = Integer.toString(guess);
    model.addAttribute("guess", "You guessed: " + guess);
    Dice newDice = new Dice();
    int thisNumber = newDice.getRolledValue();
    String roll = Integer.toString(thisNumber);
    model.addAttribute("roll", "computer rolled a: " + roll);
  if(guess > thisNumber) {
    model.addAttribute("message", "Close. If we were playing price is right rules, you would have won.");
  } else if (guess < thisNumber) {
    model.addAttribute("message", "Nope. Sorry. Try Again");
  } else if (guess == thisNumber) {
    model.addAttribute("message", "YOU GUESSED THE NUMBER");
  }
    //render src/main/webapp/rolls/show.jsp
    return "show";
  }
  @GetMapping("/new")
  public String getNewDice(@RequestParam int guess, int diceCount, Model model) throws Exception {
    String yourGuess = Integer.toString(guess);
    model.addAttribute("guess", "You guessed: " + guess);
    Dice newDice = new Dice();
    int thisNumber = newDice.getRolledValue();
    if(diceCount > 0 ) {
      thisNumber = thisNumber * diceCount;
    }
    String roll = Integer.toString(thisNumber);
    model.addAttribute("roll", "computer rolled a: " + roll);
    if(guess > thisNumber) {
      model.addAttribute("message", "Close. If we were playing price is right rules, you would have won.");
      model.addAttribute("styling", "");
    } else if (guess < thisNumber) {
      model.addAttribute("message", "Nope. Sorry. Try Again");
      model.addAttribute("styling", "");
    } else if (guess == thisNumber) {
      model.addAttribute("message", "YOU GUESSED THE NUMBER");
      model.addAttribute("styling", "font-weight:bold");
    }
    //render src/main/webapp/rolls/show.jsp
    return "show";
  }
  //could refactor to have entire thing in if/else statement to account for guess being optional to avoid NPE
}
