package com.surivalcoding.composerecipeapp.data.remote.data_source

import com.surivalcoding.composerecipeapp.data.remote.dto.RecipeDto
import com.surivalcoding.composerecipeapp.data.remote.dto.RecipesResult
import kotlinx.serialization.json.Json
import javax.inject.Inject

class MockProdRecipeDataSourceImpl @Inject constructor() : RecipeDataSource {
    private val json = """
        {
          "recipes": [
            {
              "category": "Italian",
              "id": 1,
              "name": "Traditional spare ribs baked",
              "image": "https://d2u3dcdbebyaiu.cloudfront.net/uploads/atch_img/150/667b0f908da4e242180cf0ca1880c556_res.jpeg",
              "chef": "Chef John",
              "time": "20 min",
              "rating": 4.0,
              "date": "250207",
              "ingredients": [
                {
                    "id": 3,
                    "name": "Pork",
                    "image": "https://cdn.pixabay.com/photo/2019/12/20/14/44/meat-4708596_1280.jpg",
                    "amount": 500
                },
                {
                    "id": 9,
                    "name": "Onion",
                    "image": "https://cdn.pixabay.com/photo/2013/02/21/19/14/onion-bulbs-84722_1280.jpg",
                    "amount": 50
                },
                {
                    "id": 8,
                    "name": "Pepper",
                    "image": "https://cdn.pixabay.com/photo/2016/03/05/22/31/pepper-1239308_1280.jpg",
                  "amount": 10
                },
                {
                    "id": 1,
                    "name": "Tomato",
                    "image": "https://cdn.pixabay.com/photo/2017/10/06/17/17/tomato-2823826_1280.jpg",
                  "amount": 100
                }
              ]
            },
            {
              "id": 2,
              "category": "Italian",
              "name": "Spice roasted chicken with flavored rice",
              "image": "https://i.pinimg.com/736x/35/d8/48/35d848a665f27f3c75f0e8234f7f69ce.jpg",
              "chef": "Mark Kelvin",
              "time": "20 min",
              "rating": 4.0,
              "date": "250807",
              "ingredients": [
                {
                    "id": 6,
                    "name": "Chicken",
                    "image": "https://cdn.pixabay.com/photo/2010/12/10/08/chicken-1140_1280.jpg",
                  "amount": 300
                },
                {
                    "id": 4,
                    "name": "Rice",
                    "image": "https://cdn.pixabay.com/photo/2016/02/29/05/46/brown-rice-1228099_1280.jpg",
                  "amount": 200
                },
                {
                    "id": 8,
                    "name": "Pepper",
                    "image": "https://cdn.pixabay.com/photo/2016/03/05/22/31/pepper-1239308_1280.jpg",
                  "amount": 5
                },
                {
                    "id": 3,
                    "name": "Pork",
                    "image": "https://cdn.pixabay.com/photo/2019/12/20/14/44/meat-4708596_1280.jpg",
                  "amount": 500
                }
              ]
            },
            {
              "id": 3,
              "category": "Italian",
              "name": "Spicy fried rice mix chicken bali",
              "image": "https://scontent-gmp1-1.xx.fbcdn.net/v/t1.6435-9/33893749_2133613056916900_1854177672771403776_n.png?_nc_cat=105&ccb=1-7&_nc_sid=127cfc&_nc_ohc=4fNEpGFtEh4Q7kNvgEqyHs7&_nc_zt=23&_nc_ht=scontent-gmp1-1.xx&_nc_gid=AALcdNjZHwFWzI1xz81Gjdd&oh=00_AYDJNAQpxPygsYxzAyvw2g6Mj2RsuXsA1C_Le03fqiCT1Q&oe=67B9ED4F",
              "chef": "Spicy Nelly",
              "time": "20 min",
              "rating": 4.0,
              "date": "240207",
              "ingredients": [
                {
                    "id": 6,
                    "name": "Chicken",
                    "image": "https://cdn.pixabay.com/photo/2010/12/10/08/chicken-1140_1280.jpg",
                  "amount": 200
                },
                {
                    "id": 4,
                    "name": "Rice",
                    "image": "https://cdn.pixabay.com/photo/2016/02/29/05/46/brown-rice-1228099_1280.jpg",
                  "amount": 150
                },
                {
                    "id": 1,
                    "name": "Tomato",
                    "image": "https://cdn.pixabay.com/photo/2017/10/06/17/17/tomato-2823826_1280.jpg",
                  "amount": 100
                }
              ]
            },
            {
              "category": "Italian",
              "id": 4,
              "name": "Ttekbokki",
              "image": "https://i.pinimg.com/736x/4c/42/23/4c4223fe633e2774a886289207cf3f15.jpg",
              "chef": "Kim Dahee",
              "time": "30 min",
              "rating": 5.0,
              "date": "240607",
              "ingredients": []
            },
            {
              "id": 5,
              "category": "Italian",
              "name": "Grilled salmon with avocado salsa",
              "image": "https://cdn.pixabay.com/photo/2014/11/05/15/57/salmon-518032_1280.jpg",
              "chef": "Alice Johnson",
              "time": "25 min",
              "rating": 4.5,
              "date": "210207",
              "ingredients": [
                {
                    "id": 5,
                    "name": "Avocado",
                    "image": "https://cdn.pixabay.com/photo/2020/01/02/01/43/avocado-4734786_1280.jpg",
                  "amount": 150
                },
                {
                    "id": 8,
                    "name": "Pepper",
                    "image": "https://cdn.pixabay.com/photo/2016/03/05/22/31/pepper-1239308_1280.jpg",
                  "amount": 5
                }
              ]
            },
            {
              "id": 6,
              "category": "British",
              "name": "Beef Wellington",
              "image": "https://cdn.pixabay.com/photo/2019/10/22/10/11/beef-wellington-4568239_1280.jpg",
              "chef": "Gordon Ramsay",
              "time": "45 min",
              "rating": 5.0,
              "date": "250107",
              "ingredients": [
                {
                    "id": 2,
                    "name": "Beef",
                    "image": "https://cdn.pixabay.com/photo/2016/01/21/18/08/meet-1154341_1280.png",
                  "amount": 500
                },
                {
                    "id": 9,
                    "name": "Onion",
                    "image": "https://cdn.pixabay.com/photo/2013/02/21/19/14/onion-bulbs-84722_1280.jpg",
                  "amount": 100
                }
              ]
            },
            {
              "id": 7,
              "category": "Italian",
              "name": "Classic Margherita Pizza",
              "image": "https://cdn.pixabay.com/photo/2019/05/15/18/56/pizza-4205701_1280.jpg",
              "chef": "Mario Batali",
              "time": "15 min",
              "rating": 4.3,
              "date": "240617",
              "ingredients": [
                {
                    "id": 1,
                    "name": "Tomato",
                    "image": "https://cdn.pixabay.com/photo/2017/10/06/17/17/tomato-2823826_1280.jpg",
                  "amount": 200
                }
              ]
            },
            {
              "id": 8,
              "category": "Japanese",
              "name": "Sushi Platter",
              "image": "https://cdn.pixabay.com/photo/2017/10/15/11/41/sushi-2853382_1280.jpg",
              "chef": "Jiro Ono",
              "time": "60 min",
              "rating": 4.8,
              "date": "191207",
              "ingredients": [
                {
                    "id": 6,
                    "name": "Chicken",
                    "image": "https://cdn.pixabay.com/photo/2010/12/10/08/chicken-1140_1280.jpg",
                  "amount": 200
                },
                {
                    "id": 4,
                    "name": "Rice",
                    "image": "https://cdn.pixabay.com/photo/2016/02/29/05/46/brown-rice-1228099_1280.jpg",
                  "amount": 100
                }
              ]
            },
            {
              "id": 9,
              "category": "French",
              "name": "French Onion Soup",
              "image": "https://cdn.pixabay.com/photo/2016/03/03/16/19/food-1234483_1280.jpg",
              "chef": "Julia Child",
              "time": "40 min",
              "rating": 4.6,
              "date": "20201010",
              "ingredients": [
                {
                    "id": 9,
                    "name": "Onion",
                    "image": "https://cdn.pixabay.com/photo/2013/02/21/19/14/onion-bulbs-84722_1280.jpg",
                  "amount": 300
                }
              ]
            },
            {
              "id": 10,
              "category": "French",
              "name": "Chocolate Lava Cake",
              "image": "https://cdn.pixabay.com/photo/2016/11/22/18/52/cake-1850011_1280.jpg",
              "chef": "Paul Hollywood",
              "time": "30 min",
              "rating": 4.9,
              "date": "220207",
              "ingredients": [
                {
                    "id": 7,
                    "name": "Sugar",
                    "image": "https://cdn.pixabay.com/photo/2014/11/28/19/10/lump-sugar-549096_1280.jpg",
                  "amount": 100
                }
              ]
            }
          ]
        }
    """.trimIndent()

    override suspend fun getRecipes(): List<RecipeDto> {
        return Json.decodeFromString<RecipesResult>(json).recipes ?: emptyList()
    }
}