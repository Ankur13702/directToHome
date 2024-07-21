package main.scala.passbook

class WalletBalance extends account{

  def currentBalance() {

    println("Current balance is " + main.scala.driver.DirectToHome.currentBal + " Rs.")
  }

  def recharge(rechBal: Int) {

    main.scala.driver.DirectToHome.currentBal = main.scala.driver.DirectToHome.currentBal + rechBal

    println("Recharge completed successfully. Current balance is " + main.scala.driver.DirectToHome.currentBal)

  }

}