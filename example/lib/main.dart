import 'dart:async';

import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:keep/keep.dart';

void main() => runApp(MyApp());

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  @override
  void initState() {
    super.initState();
    initPlatformState();
  }

  Future<void> initPlatformState() async {
    try {
      await Keep.keepAlive;
      print('Success to open keepAlive');
    } on PlatformException {
      print('Failed to open keepAlive');
    }
    if (!mounted) return;
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('KeepAlive Plugin example app'),
        ),
        body: Center(
          child: Text('AutoRun in initState'),
        ),
      ),
    );
  }
}
