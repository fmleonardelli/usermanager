package com.company.usermanager.controllers

import com.company.usermanager.model.User
import com.company.usermanager.repository.UserRepository
import javax.inject._
import play.api.mvc._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(cc: ControllerComponents, userRepository : UserRepository) extends AbstractController(cc) {

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index() = Action { implicit request: Request[AnyContent] =>

    userRepository.insertUser(User("fleonardelli", 1000))
    userRepository.findAll().map(r => println(r))
    Ok("This Works!!!")
  }
}
