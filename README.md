# Asset Manager (資産管理アプリ)

Spring Bootを使用して作成した、シンプルな家計簿・資産管理アプリケーションです。
日々の支出を記録し、データベースに保存すると同時に、全支出の合計金額を自動計算して表示します。

※本アプリケーションは、Javaの基礎学習およびSpring Bootの実践的な理解を目的に作成しました。

## 機能一覧 (Features)

* **支出の記録**: 日付、項目、金額を入力してデータベースに保存します。
* **一覧表示**: 過去の支出履歴を表形式で確認できます。
* **合計計算**: Serviceクラス内のロジックにより、登録された全データの合計支出をリアルタイムで算出し、トップページに表示します。

## 学んだこと (Learning Outcomes)

このプロジェクトでは、単なるCRUD（登録・表示）だけでなく、**「データを加工・計算するロジック」**の実装に重点を置きました。

### 1. ビジネスロジックの実装 (Service)
* Repositoryからデータを取得して終わりではなく、Serviceクラス内で `for` 文を用いた計算処理 (`getTotalAmount`) を実装しました。
* Controller、Service、Repositoryの役割分担を意識し、「計算はService」「表示はController」と責務を分離しました。

### 2. Javaの型システムの理解
* **プリミティブ型 (`int`)** と **ラッパークラス (`Integer`)** の違いを学び、適切に使い分けました。
    * データベースとやり取りするEntityでは `null` を許容する `Integer` を使用。
    * 計算ロジック内では計算の確実性を担保するため `int` を使用。

### 3. クラウド開発環境でのトラブルシューティング
* GitHub Codespacesでの開発時、リダイレクト処理においてポート番号が不正に付与される問題に直面しました。
* フレームワークの挙動を調査し、`application.properties` に `server.forward-headers-strategy=framework` を設定することで解決しました。

### 4. 日付データの扱い
* `java.time.LocalDate` クラスを使用し、HTMLの `<input type="date">` とJavaオブジェクト間のデータバインディングを実装しました。

## 使用技術 (Tech Stack)

* Java 21
* Spring Boot 3.4.1
* Thymeleaf
* Spring Data JPA
* H2 Database
* Lombok

## 起動方法 (How to Run)

1. リポジトリをクローンします。
    git clone https://github.com/NK0807/asset-manager.git

2. ディレクトリに移動します。
    cd asset-manager

3. アプリケーションを起動します。
    ./mvnw spring-boot:run

4. ブラウザでアクセスします。
   http://localhost:8080

## ディレクトリ構成

* src/main/java/com/example/asset_manager
    * controller (画面遷移の制御)
    * service (合計金額の計算ロジック)
    * repository (DB操作)
    * entity (データ構造)
* src/main/resources/templates (HTML)
