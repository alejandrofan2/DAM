import 'package:flutter/material.dart';

class LightTheme {
  static const brightness = Brightness.light;
  static const primaryColor = const Color.fromARGB(255, 71, 207, 4);
  static const lightColor = const Color.fromARGB(255, 220, 220, 220);
  static const backgroundColor = const Color.fromARGB(255, 255, 255, 255);
  static const reverseColor = const Color.fromARGB(255, 0, 0, 0);

  static ThemeData getLightTheme() {
    return ThemeData(
      brightness: brightness,
    );
  }
}
