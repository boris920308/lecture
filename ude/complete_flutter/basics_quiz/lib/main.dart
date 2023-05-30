import 'package:flutter/material.dart';
import 'package:basics_quiz/GradientContainer.dart';

void main() {
  runApp(
    const MaterialApp(
      home: Scaffold(
        body: GradientContainer(
          Color.fromARGB(131, 59, 131, 173),
          Colors.white,
        ),
      ),
    ),
  );
}
