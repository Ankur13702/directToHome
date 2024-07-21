package main.scala.operatorpackage

class BasePackage extends main.scala.subscription.SubscriptionChannelServices {

  var channelKeys = channelList.keys.toSeq
  var channelValue = channelList.values.toSeq

  def silver(): String = {

    println("Silver pack:" + channelKeys(3) + "," + channelKeys(1) + "," + channelKeys(2) + ": 50 Rs.")

    return " Silver pack:" + channelKeys(3) + "," + channelKeys(1) + "," + channelKeys(2) + ": 50 Rs."

  }

  def gold(): String = {

    println("Gold pack:" + channelKeys(3) + "," + channelKeys(0) + "," + channelKeys(1) + "," + channelKeys(2) + "," + channelKeys(4) + ": 100 Rs.")

    return "Gold pack:" + channelKeys(3) + "," + channelKeys(0) + "," + channelKeys(1) + "," + channelKeys(2) + "," + channelKeys(4) + ": 100 Rs."
  }

  def listChannel() {

    for ((k, v) <- channelList) {

      println(k + ":" + v + " Rs.")
    }

  }

  def listService() {

    for ((k, v) <- serviceList) {

      println(k + ":" + v + " Rs.")
    }

  }

}