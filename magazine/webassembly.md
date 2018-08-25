<style>
body {
  font-family: "Source Code Pro";
}
p {
  text-indent: 1em;
}
</style>

# WebAssembly

WebAssembly はコードのフォーマットのひとつです．

WebAssembly is standard, a safe, portable, low-level code format designed for efficient execution and compact representation. 

## Sections

- Type: 関数のシグネチャの配列
- Import: インポートの配列
- Function: 関数宣言の配列
- Table: テーブルの構成
- Liner-Memory: 線形メモリの構成
- Global: グローバル宣言の配列
- Export: エクスポートの配列
- Start: 関数インデックス空間へのvaruint32インデックス
- Element: テーブルイニシャライザの配列
- Code: 関数本体の配列
- Data: データイニシャライザの配列

