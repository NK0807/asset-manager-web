# Asset Manager Web (資産管理アプリ Webバージョン)

Spring Bootを使用して作成した、実務を意識した家計簿・資産管理アプリケーションです。
日々の支出の記録・編集・削除（CRUD）を完備し、入力値の検証（バリデーション）によってデータの整合性を保つ設計となっています。

※本アプリケーションは、JavaおよびSpring Bootを用いたWebアプリケーション開発の実践的なスキル習得を目的に作成しました。

## 機能一覧 (Features)

* **支出の記録 (Create)**: 日付、項目、金額を入力してデータベースに保存します。
* **一覧表示 (Read)**: 過去の支出履歴を表形式で確認できます。
* **詳細編集 (Update)**: 登録済みのデータを呼び出し、内容を修正して上書き保存できます。
* **削除機能 (Delete)**: 不要になったデータをID指定で安全に削除できます。
* **入力チェック (Validation)**: 必須入力や金額の範囲（マイナス不可）などを厳格にチェックし、不正なデータの登録を防ぎます。
* **合計計算**: Serviceクラス内のロジックにより、全支出の合計金額をリアルタイムで算出し、トップページに表示します。

## 学んだこと (Learning Outcomes)

このプロジェクトでは、単なる機能実装だけでなく、「堅牢な業務アプリケーション」を作るための設計と実装に重点を置きました。

### 1. CRUDの完全実装
* Webアプリの基本である **Create（登録）、Read（表示）、Update（更新）、Delete（削除）** の4機能を独力で実装しました。
* 特に「更新（Update）」においては、`@PathVariable` を用いたIDの受け渡しや、hiddenフィールドを使ったデータの引き継ぎなど、Web特有のデータの流れを理解しました。

### 2. バリデーション（入力チェック）の実装
* データの整合性を保つため、`Spring Validation` を導入しました。
    * `@NotNull`, `@Size`, `@Min` などのアノテーションを活用し、Entityレベルでルールを定義。
    * Controllerで `BindingResult` を用いてエラーを検知し、ユーザーに適切なエラーメッセージを画面表示する仕組みを構築しました。

### 3. ビジネスロジックと責務の分離
* Controllerにすべてを書くのではなく、計算処理やDB操作の呼び出しはServiceクラスに集約させました。
* 「画面制御はController」「ロジックはService」「データ操作はRepository」というMVCアーキテクチャの基本を徹底しました。

### 4. Javaの型システムの適切な使い分け
* データベースとやり取りするEntityでは `null` を許容する `Integer` を使用し、計算ロジック内では確実性を担保するため `int` を使用するなど、目的意識を持って型を選定しました。

### 5. クラウド開発環境でのトラブルシューティング
* GitHub Codespacesでの開発時、リダイレクト処理においてポート番号が不正に付与される問題に直面しましたが、フレームワークの設定（`server.forward-headers-strategy`）を見直すことで自己解決しました。

## 使用技術 (Tech Stack)

* Java 21
* Spring Boot 3.4.1
* Spring Boot Validation (入力チェック)
* Thymeleaf
* Spring Data JPA
* H2 Database
* Lombok

## 起動方法 (How to Run)

1. リポジトリをクローンします。
    git clone https://github.com/NK0807/asset-manager-web.git

2. ディレクトリに移動します。
    cd asset-manager

3. アプリケーションを起動します。
    ./mvnw spring-boot:run

4. ブラウザでアクセスします。
   http://localhost:8080

## ディレクトリ構成

* src/main/java/com/example/asset_manager
    * controller (画面遷移・入力チェックの制御)
    * service (CRUD操作の呼び出し・計算ロジック)
    * repository (DB操作インターフェース)
    * entity (データ構造・バリデーション定義)
* src/main/resources/templates (HTML/Thymeleaf)
    * index.html (一覧・登録画面)
    * edit.html (編集画面)
