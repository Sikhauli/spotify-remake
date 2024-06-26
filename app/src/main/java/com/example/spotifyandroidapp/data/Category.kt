package com.example.spotifyandroidapp.data

data class CategoryData(
  val img: String,
  val artist: String,
  val album: String
)

data class LibraryData(
  val img: String,
  val artist: String,
  val album: String,
  val type: String
)


val madeForYouCategories = listOf(
  CategoryData("https://e-cdn-images.dzcdn.net/images/artist/5d9f16fae9f8cd9f2bfd9103f08079a3/500x500-000000-80-0-0.jpg", "Shufflers", "Dilugiseleni"),
  CategoryData("https://e-cdn-images.dzcdn.net/images/artist/cf9f43ee1f0d8d3b498a155f4988087f/500x500-000000-80-0-0.jpg", "Harley", "Dooms Day"),
  CategoryData("https://lastfm.freetls.fastly.net/i/u/770x0/434a922ecca5474f1f9d6bbcc3a1050c.jpg#434a922ecca5474f1f9d6bbcc3a1050c","Drake","More Life"),
  CategoryData("https://t2.genius.com/unsafe/300x300/https%3A%2F%2Fimages.genius.com%2F58f44c045af8c84db70abf4f2d2c6e1f.1000x1000x1.jpg","Kendrick Lamar","DAMN"),
  CategoryData("https://t2.genius.com/unsafe/252x252/https%3A%2F%2Fimages.genius.com%2F130420153ed8ff63bab74dd483030456.1000x1000x1.png","Future","Mask Off"),
  CategoryData("https://t2.genius.com/unsafe/252x252/https%3A%2F%2Fimages.genius.com%2Fd97224e10b88dcd05ed18b87366461c8.600x600x1.jpg","Eminem","Without me"),
  CategoryData("https://t2.genius.com/unsafe/300x300/https%3A%2F%2Fimages.genius.com%2Fd4bb7ceb9b387c2c85a9efa0d54a2fd5.600x600x1.jpg","Snoop Dogg","Doggystyle"),
  )

val sampleMusicCategories = listOf(
  CategoryData("https://e-cdn-images.dzcdn.net/images/artist/5d9f16fae9f8cd9f2bfd9103f08079a3/500x500-000000-80-0-0.jpg", "Shufflers", "Dilugiseleni"),
  CategoryData("https://e-cdn-images.dzcdn.net/images/artist/cf9f43ee1f0d8d3b498a155f4988087f/500x500-000000-80-0-0.jpg", "Harley", "Dooms Day"),
  CategoryData("https://lastfm.freetls.fastly.net/i/u/770x0/434a922ecca5474f1f9d6bbcc3a1050c.jpg#434a922ecca5474f1f9d6bbcc3a1050c","Drake","More Life"),
  CategoryData("https://t2.genius.com/unsafe/300x300/https%3A%2F%2Fimages.genius.com%2F58f44c045af8c84db70abf4f2d2c6e1f.1000x1000x1.jpg","Kendrick Lamar","DAMN"),
  CategoryData("https://t2.genius.com/unsafe/252x252/https%3A%2F%2Fimages.genius.com%2F130420153ed8ff63bab74dd483030456.1000x1000x1.png","Future","Mask Off"),
  CategoryData("https://t2.genius.com/unsafe/252x252/https%3A%2F%2Fimages.genius.com%2Fd97224e10b88dcd05ed18b87366461c8.600x600x1.jpg","Eminem","Without me"),
  CategoryData("https://t2.genius.com/unsafe/300x300/https%3A%2F%2Fimages.genius.com%2Fd4bb7ceb9b387c2c85a9efa0d54a2fd5.600x600x1.jpg","Snoop Dogg","Doggystyle"),
)


val browseAll = listOf(
  LibraryData("https://e-cdn-images.dzcdn.net/images/artist/5d9f16fae9f8cd9f2bfd9103f08079a3/500x500-000000-80-0-0.jpg", "Shufflers", "Dilugiseleni", "album"),
  LibraryData("https://e-cdn-images.dzcdn.net/images/artist/cf9f43ee1f0d8d3b498a155f4988087f/500x500-000000-80-0-0.jpg", "Harley", "Dooms Day", "album"),
  LibraryData("https://lastfm.freetls.fastly.net/i/u/770x0/434a922ecca5474f1f9d6bbcc3a1050c.jpg#434a922ecca5474f1f9d6bbcc3a1050c","Drake","More Life", "album"),
  LibraryData("https://t2.genius.com/unsafe/300x300/https%3A%2F%2Fimages.genius.com%2F58f44c045af8c84db70abf4f2d2c6e1f.1000x1000x1.jpg","Kendrick Lamar","DAMN", "album"),
  LibraryData("https://t2.genius.com/unsafe/252x252/https%3A%2F%2Fimages.genius.com%2F130420153ed8ff63bab74dd483030456.1000x1000x1.png","Future","Mask Off", "album"),
  LibraryData("https://t2.genius.com/unsafe/252x252/https%3A%2F%2Fimages.genius.com%2Fd97224e10b88dcd05ed18b87366461c8.600x600x1.jpg","Eminem","Without me", "album"),
  LibraryData("https://t2.genius.com/unsafe/300x300/https%3A%2F%2Fimages.genius.com%2Fd4bb7ceb9b387c2c85a9efa0d54a2fd5.600x600x1.jpg","Snoop Dogg","Doggystyle", "album"),
  LibraryData("https://e-cdn-images.dzcdn.net/images/artist/cf9f43ee1f0d8d3b498a155f4988087f/500x500-000000-80-0-0.jpg", "Harley", "Dooms Day", "Artist"),
  LibraryData("https://lastfm.freetls.fastly.net/i/u/770x0/434a922ecca5474f1f9d6bbcc3a1050c.jpg#434a922ecca5474f1f9d6bbcc3a1050c","Drake","More Life", "artist"),
  LibraryData("https://t2.genius.com/unsafe/300x300/https%3A%2F%2Fimages.genius.com%2F58f44c045af8c84db70abf4f2d2c6e1f.1000x1000x1.jpg","Kendrick Lamar","DAMN", "artist"),
  LibraryData("https://t2.genius.com/unsafe/252x252/https%3A%2F%2Fimages.genius.com%2F130420153ed8ff63bab74dd483030456.1000x1000x1.png","Future","Mask Off", "artist"),
  LibraryData("https://t2.genius.com/unsafe/252x252/https%3A%2F%2Fimages.genius.com%2Fd97224e10b88dcd05ed18b87366461c8.600x600x1.jpg","Eminem","Without me", "artist"),
  LibraryData("https://t2.genius.com/unsafe/300x300/https%3A%2F%2Fimages.genius.com%2Fd4bb7ceb9b387c2c85a9efa0d54a2fd5.600x600x1.jpg","Snoop Dogg","Doggystyle", "artist"),
  LibraryData("https://t2.genius.com/unsafe/300x300/https%3A%2F%2Fimages.genius.com%2F58f44c045af8c84db70abf4f2d2c6e1f.1000x1000x1.jpg","Kendrick Lamar","DAMN", "playlist"),
  LibraryData("https://t2.genius.com/unsafe/252x252/https%3A%2F%2Fimages.genius.com%2F130420153ed8ff63bab74dd483030456.1000x1000x1.png","Future","Mask Off", "playlist"),
  LibraryData("https://t2.genius.com/unsafe/252x252/https%3A%2F%2Fimages.genius.com%2Fd97224e10b88dcd05ed18b87366461c8.600x600x1.jpg","Eminem","Without me", "playlist"),
  LibraryData("https://t2.genius.com/unsafe/300x300/https%3A%2F%2Fimages.genius.com%2Fd4bb7ceb9b387c2c85a9efa0d54a2fd5.600x600x1.jpg","Snoop Dogg","Doggystyle", "playlist"),

  )