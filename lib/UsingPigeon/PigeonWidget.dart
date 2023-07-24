import 'package:flutter/material.dart';
import 'package:methodchanneldemo_sample1/batteryinfoApi.dart';

class PigeonWidget extends StatefulWidget {
  String batteryLevel = 'Unknown level.';

  PigeonWidget({super.key});

  @override
  State<PigeonWidget> createState() => _HomePageState();
}

Future<String?> getInfo() async {
  try {
    /// Use the [_fileApi] to attempt instructing native platforms
    /// to save the text file based on the [FileData] data class
    var batteryApi = BatteryInfoApi();

    final response = await batteryApi.getbatteryInformation();

    /// return the status of the request
    return response.batteryPercentage;
  } catch (e) {
    /// return [false] if an exception was thrown
    return e.toString();
  }
}

class _HomePageState extends State<PigeonWidget> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.spaceEvenly,
          children: [
            ElevatedButton(
              onPressed: _getBatteryLevel,
              child: const Text('Get Battery Level'),
            ),
            Text('Battery percentage is-- ${widget.batteryLevel}'),
          ],
        ),
      ),
    );
  }

  // Get battery level.

  _getBatteryLevel() {
    getInfo().then((value) {
      setState(() {
        widget.batteryLevel = value!;
      });
    });
  }
}
