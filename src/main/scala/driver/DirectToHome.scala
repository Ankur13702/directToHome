package main.scala.driver

import main.scala.passbook.WalletBalance
import main.scala.operatorpackage.BasePackage
import main.scala.userinfo.Customer

object DirectToHome extends main.scala.subscription.SubscriptionChannelServices {

  var currentBal = 100
  var subscribedPackage = ""
  var subscribChannel = ""
  var subscribeServices = ""

  def main(args: Array[String]) {

    while (true) {

      println("Welcome to SatTV")
      println("1. View current balance in the account")
      println("2. Recharge Account")
      println("3. View available packs, channels and services")
      println("4. Subscribe to base packs")
      println("5. Add channels to an existing subscription")
      println("6. Subscribe to special services")
      println("7. View current subscription details")
      println("8. Update email and phone number for notifications")
      println("9. Exit")

      var input = scala.io.StdIn.readInt()

      var bal = new WalletBalance()
      var basepack = new BasePackage()
      var cust = new Customer()

      input match {

        case 1 =>
          bal.currentBalance()

        case 2 =>

          {
            println("Enter the amount to recharge:")
            try {
              var recharge_amount = scala.io.StdIn.readInt()
              bal.recharge(recharge_amount)
              recharge_amount.isNaN()
            } catch {

              case x: Exception =>
                {
                  println("This is invalid amount ,Please Enter the valid amount")

                }

            }

          }

        case 3 =>
          {
            println("Available packs for subscription")
            basepack.silver()
            basepack.gold()
            println("Available channels for subscription")
            basepack.listChannel()
            println("Available services for subscription")
            basepack.listService()

          }
        case 4 =>

          {
            println("Enter the Pack you wish to subscribe: (Silver: ‘S’, Gold: ‘G’)")
            var packOption = scala.io.StdIn.readChar()

            if (packOption != 'S' && packOption != 'G') {
              println("Please Enter Correct Pack")
              return
            } else {

              println("Enter the months:")
              var monOption = scala.io.StdIn.readInt()

              if (monOption >= 3) {

                if (packOption == 'S') {

                  try {
                    subscribedPackage.contains("Silver") && packOption.isWhitespace

                  } catch {

                    case x: Exception =>
                      {
                        println("Pack is already subscribed ")

                      }
                  }

                  subscribedPackage = subscribedPackage + "Silver"
                  var packageValue = 50 * monOption

                  if (currentBal < packageValue) {
                    println("Please Select pack less or equal to your package")
                  } else {
                    currentBal = (currentBal - packageValue) + (packageValue * 0.1).toInt
                    println("You have successfully subscribed the following packs - Silver")
                    println("Monthly price: " + 50 + " Rs.")
                    println("No of months:" + monOption)
                    println("Subscription Amount:" + (50 * monOption) + " Rs.")
                    println("Discount applied: " + (packageValue * 0.1 + " Rs."))
                    println("Final Price after discount: " + (packageValue - (packageValue * 0.1).toInt) + " Rs.")
                    println("Account balance: " + currentBal + " Rs.")
                    println("Email notification sent successfully")
                    println("SMS notification sent successfully")
                  }

                } else if (packOption == 'G') {

                  subscribedPackage = subscribedPackage + "Gold"
                  var packageValue = 100 * monOption

                  if (currentBal < packageValue) {
                    println("Please Select pack less or equal to your package")
                  } else {
                    currentBal = (currentBal - packageValue) + (packageValue * 0.1).toInt
                    println("You have successfully subscribed the following packs - Gold")
                    println("Monthly price: " + 100 + " Rs.")
                    println("No of months:" + monOption)
                    println("Subscription Amount:" + (100 * monOption) + " Rs.")
                    println("Discount applied: " + (packageValue * 0.1 + " Rs."))
                    println("Final Price after discount: " + (packageValue - (packageValue * 0.1).toInt) + " Rs.")
                    println("Account balance: " + currentBal + " Rs.")
                    println("Email notification sent successfully")
                    println("SMS notification sent successfully")

                  }
                } else {

                  println("Enter either S or G")
                }

              } else {
                var packageValue = 50 * monOption
                if (packageValue <= currentBal) {
                  println("Please Select pack less or equal to your package")
                } else {

                  currentBal = (currentBal - packageValue)
                }

              }
            }
          }

        case 5 =>
          {
            println("Add channels to existing subscription")
            println("Enter channel names to add (separated by commas):")
            var channelInput = scala.io.StdIn.readLine()
            var channelArr = channelInput.split(",")

            for (i <- 0 to (channelArr.length - 1)) {

              for ((k, v) <- channelList) {

                if (channelArr(i) == k) {
                  currentBal = currentBal - v.toInt
                  subscribChannel = subscribChannel + " " + k + " "

                }

              }

            }

            println("Channels added successfully.")
            println("Account balance: " + currentBal + " Rs")

          }

        case 6 =>

          {

            println("Subscribe to special services")
            println("Enter the service name:")
            var serviceInput = scala.io.StdIn.readLine()
            var serviceArr = serviceInput.split(",")

            for (j <- 0 to (serviceArr.length - 1)) {

              for ((a, b) <- serviceList) {

                if (serviceArr(j) == a) {
                  currentBal = currentBal - b.toInt
                  subscribeServices = subscribeServices + " " + a + " "

                }

              }

            }

            println("Service subscribed successfully.")
            println("Account balance: " + currentBal + " Rs")
            println("Email notification sent successfully")
            println("SMS notification sent successfully")

          }

        case 7 =>

          {

            println("View current subscription details")
            println("Currently subscribed packs and channels: " + subscribedPackage + "+" + subscribChannel)
            println("Currently subscribed services:" + subscribeServices)

          }

        case 8 =>

          {

            println("Update email and phone number for notifications")
            println("Enter the email:")
            var email = scala.io.StdIn.readLine()
            println("Enter phone:")
            var ContactNo = scala.io.StdIn.readLine()
            cust.addCustomerDetails(email, ContactNo)

          }

        case 9 => return
      }
    }

  }

}