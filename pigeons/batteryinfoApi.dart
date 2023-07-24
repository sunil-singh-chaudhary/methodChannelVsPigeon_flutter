import 'package:pigeon/pigeon.dart';

//Data class to be sent as a message
class BatteryInfo {
  String? batteryPercentage;
}

@HostApi()
abstract class BatteryInfoApi {
  ///This abstract function will contain code that performs communication
  ///with native platforms, sending in [FileData] as a message and receiving [Response] as a response.
  BatteryInfo getbatteryInformation();
}
