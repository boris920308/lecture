import 'package:flutter/material.dart';
import 'package:roll_dice/gradient_container.dart';

void main() {
  runApp(
    MaterialApp(
      home: Scaffold(
        // backgroundColor: Color.fromARGB(255, 12, 58, 59),
        body: GradientContainer(
          const Color.fromARGB(225, 206, 104, 104),
          const Color.fromARGB(224, 160, 117, 117),
        ),
      ),
    ),
  );
}
