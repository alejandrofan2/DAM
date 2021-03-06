import 'package:tea_shop/pages/cart.page.dart';
import 'package:tea_shop/pages/home.page.dart';
import 'package:tea_shop/pages/login.page.dart';
import 'package:flutter/material.dart';
import 'package:tea_shop/main.dart';
import 'package:tea_shop/themes/dark_theme.dart';
import 'package:tea_shop/themes/light_theme.dart';

class TabsPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: TabBarView(children: [HomePage(), CartPage(), LoginPage()]),
      bottomNavigationBar: TabBar(
        tabs: [
          Tab(
            icon: Icon(Icons.home),
          ),
          Tab(
            icon: Icon(Icons.shopping_cart),
          ),
          Tab(
            icon: Icon(Icons.perm_identity),
          ),
        ],
        labelColor:
            MyApp.darkMode ? DarkTheme.primaryColor : LightTheme.primaryColor,
        unselectedLabelColor:
            MyApp.darkMode ? DarkTheme.lightColor : LightTheme.lightColor,
        indicatorSize: TabBarIndicatorSize.label,
        indicatorPadding: EdgeInsets.all(5),
      ),
    );
  }
}
