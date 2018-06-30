package com.example.helloAkka

import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props

// Define Actor messages
case class WhoToGreet(who: String)

// Define Greeter Actor
class Greeter extends Actor {
  def receive = {
    case WhoToGreet(who) => println(s"Hello $who")
  }
}

object HelloAkka extends App {
 
  // Create the `hello akka` Actor system
  val system = ActorSystem("Hello-Akka")
  
  // Create the `Greeter` Actor
  val greeter = system.actorOf(Props[Greeter], "greeter")
  
  // Send WhoToGreet Message to Actor
  greeter ! WhoToGreet("Akka")
}