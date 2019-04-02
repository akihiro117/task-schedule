# task-schedule 

## 概要
これは、タスク管理を行うためのWebアプリケーションです。
Spring bootや、thymeleaf、spring securityを試すために作りました。

## 詳細
### このアプリケーションがユーザに提供する機能
- ユーザのメールアドレスを用いた会員登録、ログイン(アクティベーションは実装していません)。
- タスクの登録。
- タスクの編集(未実装)。
- タスクの削除(未実装)。
- 全てのタスクの表示。
- ページ閲覧日時に実施予定のタスクの表示。
- ログアウト。

## 使用技術、ツール等
- サーバー: Tomcat8
- Jdk: 1.8
- フレームワーク: Spring boot 2.1.1
- データベース: Postgresql 
- テンプレートエンジン: Thymeleaf
- Build: Maven

## 実行方法
1. create_tables.sql(これから作成予定)を実行してテーブルを作成してください。
2. application.propertiesはここに上げていないので、
自身が作成したdatabaseの設定をapplication.propertiesに書いて、
src/main/resources/ に置いてからbuildします。
3. ./mvnw spring-boot:run をプロジェクトのルートで実行します。
4. ブラウザで http://localhost:8080 にアクセスします。

## その他
- パスワードはハッシュ化を行なってDBに登録します。ログイン認証にはspring securityを使用しています。
- Thymeleafを使用することで、CSRF対策を行なっています。
- MybatisでSqlインジェクション対策を行なっています。
