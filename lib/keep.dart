import 'dart:async';

import 'package:flutter/services.dart';

class Keep {
  static const MethodChannel _channel = const MethodChannel('keep');

  static Future<String> get keepAlive async {
    final String version = await _channel.invokeMethod('keepAlive');
    return version;
  }
}
