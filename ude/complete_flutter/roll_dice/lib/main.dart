import 'package:flutter/material.dart';
import 'package:roll_dice/gradient_container.dart';

void main() {
  runApp(
    const MaterialApp(
      home: Scaffold(
        // backgroundColor: Color.fromARGB(255, 12, 58, 59),
        body: GradientContainer(
          Color.fromARGB(225, 206, 104, 104),
          Color.fromARGB(224, 160, 117, 117),
        ),
      ),
    ),
  );
}
