# Oishii Order - オンラインフード注文システム

Oishii Orderは、ユーザーがメニューの閲覧、料理の注文、および注文履歴の管理を行うことができるシンプルなウェブアプリケーションです。このプロジェクトはSpring BootとMySQLを使用して構築されています。

## 🚀 主な機能

- **ユーザー管理**: ユーザー登録、ログイン、およびアカウント管理。
- **メニュー表示**: 料理のリストを価格や画像とともに表示。
- **注文システム**: ユーザーが好きな料理を選択し、オンラインで注文を確定。
- **注文履歴**: 過去の注文状況や詳細を追跡。

## 🛠️ 使用技術

### バックエンド
- **フレームワーク**: Spring Boot 3.2.1
- **言語**: Java 20
- **データベース**: MySQL
- **ORM**: Spring Data JPA

### フロントエンド
- HTML5, CSS3, JavaScript (Vanilla JS)

### ビルドツール
- Maven

## 📋 システム要件

- Java JDK 20 以上
- MySQL Server
- Maven

## 🔧 セットアップと実行方法

1. **プロジェクトをクローンする**:
   ```bash
   git clone <your-repository-url>
   cd Oishii-Order-v0
   ```

2. **データベースの設定**:
   - MySQLで `food_order_db` という名前のデータベースを作成します。
   - `src/main/resources/application.properties` ファイルを開き、MySQLの接続情報（ユーザー名とパスワード）を更新します：
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/food_order_db
     spring.datasource.username=root
     spring.datasource.password=your_password
     ```

3. **アプリケーションの起動**:
   Mavenを使用して起動する場合：
   ```bash
   mvn spring-boot:run
   ```
   または、IDE（IntelliJ IDEA, Eclipse, VS Codeなど）から `FoodOrderApplication.java` を実行してください。

4. **アクセス**:
   ブラウザで `http://localhost:8080` を開きます。

## 📂 ディレクトリ構成

- `src/main/java/com/foodorder`: Javaソースコード（Controller, Service, Repository, Entity）。
- `src/main/resources/static`: 静的リソース（HTML, CSS, JS）。
- `src/main/resources/application.properties`: アプリケーションの設定ファイル。

## 📝 ライセンス

このプロジェクトは学習および参照用として作成されました。
