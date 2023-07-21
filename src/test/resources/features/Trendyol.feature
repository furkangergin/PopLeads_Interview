Feature: OPTIIM Trendyol Task

  Background:
    Given Kullanıcı "https://www.trendyol.com/" url'ine gider.
    When "https://www.trendyol.com/" sayfasına gidildiği doğrulanır.
    And Çerezleri kabul et butonuna tıklanır.


  Scenario: Sepete ekleme ve çıkarma kontrolleri senaryosu.
    Given Kullanıcı giriş yap butonuna tıklar.
    When Kullanıcı login sayfasının geldiğini doğrular.
    And Kullanıcı e-posta adresi olarak "mehmetfurkangergin@gmail.com" değerini girer.
    And Kullanıcı password değeri olarak "1719.Sefa" değerini girer.
    And Giriş yap butonuna tıklar.
    And Arama alanına "samsung" yazılır ve arama butonuna tıklanır.
    Then Gelen sayfada "samsung" için sonuç bulunduğu doğrulanır.
    And Sol menüden akıllı saat tıklanır.
    And Üstten 2. ürün tıklanır.
    And Ürün detayında kalp butonuna tıklanarak favorilere eklenir.
    And Favorilerim kısmına tıklanır ve gelen sayfada ürün sepete eklenir.
    Then Sepete eklendi popup yazısının görüldüğü doğrulanır.
    And Kullanıcı sepetim butonuna tıklar.
    Then Sepetim sayfasının açıldığı doğrulanır.
    And Kullanıcı sepetteki ürün için kaldır butonuna tıklar.
    Then Sepetim sıfır ürün yazısının görüldüğü doğrulanır.


  @optiim
  Scenario: Sepete ekleme ve çıkarma kontrolleri senaryosu Excel ile giriş.
    Given Kullanıcı giriş yap butonuna tıklar.
    When Kullanıcı login sayfasının geldiğini doğrular.
    And Kullanıcı e-posta adresi olarak TrendyolUser excel dosyasındaki değerini girer.
    And Kullanıcı password değeri olarak TrendyolUser excel dosyasındaki değerini girer.
    And Giriş yap butonuna tıklar.
    And Arama alanına "samsung" yazılır ve arama butonuna tıklanır.
    Then Gelen sayfada "samsung" için sonuç bulunduğu doğrulanır.
    And Sol menüden akıllı saat tıklanır.
    And Üstten 2. ürün tıklanır.
    And Ürün detayında kalp butonuna tıklanarak favorilere eklenir.
    And Favorilerim kısmına tıklanır ve gelen sayfada ürün sepete eklenir.
    Then Sepete eklendi popup yazısının görüldüğü doğrulanır.
    And Kullanıcı sepetim butonuna tıklar.
    Then Sepetim sayfasının açıldığı doğrulanır.
    And Kullanıcı sepetteki ürün için kaldır butonuna tıklar.
    Then Sepetim sıfır ürün yazısının görüldüğü doğrulanır.


