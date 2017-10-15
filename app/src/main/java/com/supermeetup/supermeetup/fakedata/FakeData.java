package com.supermeetup.supermeetup.fakedata;

import com.supermeetup.supermeetup.model.Category;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by yuxin on 10/14/17.
 */

public class FakeData {
    private static String sCategories = "{\n" +
            "\"0\": {\n" +
            "\"id\": 242,\n" +
            "\"shortname\": \"outdoors-adventure\",\n" +
            "\"name\": \"Outdoors & Adventure\",\n" +
            "\"sort_name\": \"Outdoors & Adventure\",\n" +
            "\"photo\": {\n" +
            "\"id\": 450131943,\n" +
            "\"highres_link\": \"https://secure.meetupstatic.com/photos/event/2/e/a/7/highres_450131943.jpeg\",\n" +
            "\"photo_link\": \"https://secure.meetupstatic.com/photos/event/2/e/a/7/600_450131943.jpeg\",\n" +
            "\"thumb_link\": \"https://secure.meetupstatic.com/photos/event/2/e/a/7/thumb_450131943.jpeg\",\n" +
            "\"type\": \"event\",\n" +
            "\"base_url\": \"https://secure.meetupstatic.com\"\n" +
            "},\n" +
            "\"category_ids\": [\n" +
            "3,\n" +
            "23\n" +
            "]\n" +
            "},\n" +
            "\"1\": {\n" +
            "\"id\": 292,\n" +
            "\"shortname\": \"tech\",\n" +
            "\"name\": \"Tech\",\n" +
            "\"sort_name\": \"Tech\",\n" +
            "\"photo\": {\n" +
            "\"id\": 450131949,\n" +
            "\"highres_link\": \"https://secure.meetupstatic.com/photos/event/2/e/a/d/highres_450131949.jpeg\",\n" +
            "\"photo_link\": \"https://secure.meetupstatic.com/photos/event/2/e/a/d/600_450131949.jpeg\",\n" +
            "\"thumb_link\": \"https://secure.meetupstatic.com/photos/event/2/e/a/d/thumb_450131949.jpeg\",\n" +
            "\"type\": \"event\",\n" +
            "\"base_url\": \"https://secure.meetupstatic.com\"\n" +
            "},\n" +
            "\"category_ids\": [\n" +
            "34\n" +
            "]\n" +
            "},\n" +
            "\"2\": {\n" +
            "\"id\": 232,\n" +
            "\"shortname\": \"parents-family\",\n" +
            "\"name\": \"Family\",\n" +
            "\"sort_name\": \"Family\",\n" +
            "\"photo\": {\n" +
            "\"id\": 450131932,\n" +
            "\"highres_link\": \"https://secure.meetupstatic.com/photos/event/2/e/9/c/highres_450131932.jpeg\",\n" +
            "\"photo_link\": \"https://secure.meetupstatic.com/photos/event/2/e/9/c/600_450131932.jpeg\",\n" +
            "\"thumb_link\": \"https://secure.meetupstatic.com/photos/event/2/e/9/c/thumb_450131932.jpeg\",\n" +
            "\"type\": \"event\",\n" +
            "\"base_url\": \"https://secure.meetupstatic.com\"\n" +
            "},\n" +
            "\"category_ids\": [\n" +
            "25\n" +
            "]\n" +
            "},\n" +
            "\"3\": {\n" +
            "\"id\": 302,\n" +
            "\"shortname\": \"health-wellness\",\n" +
            "\"name\": \"Health & Wellness\",\n" +
            "\"sort_name\": \"Health & Wellness\",\n" +
            "\"photo\": {\n" +
            "\"id\": 450131950,\n" +
            "\"highres_link\": \"https://secure.meetupstatic.com/photos/event/2/e/a/e/highres_450131950.jpeg\",\n" +
            "\"photo_link\": \"https://secure.meetupstatic.com/photos/event/2/e/a/e/600_450131950.jpeg\",\n" +
            "\"thumb_link\": \"https://secure.meetupstatic.com/photos/event/2/e/a/e/thumb_450131950.jpeg\",\n" +
            "\"type\": \"event\",\n" +
            "\"base_url\": \"https://secure.meetupstatic.com\"\n" +
            "},\n" +
            "\"category_ids\": [\n" +
            "14,\n" +
            "33\n" +
            "]\n" +
            "},\n" +
            "\"4\": {\n" +
            "\"id\": 282,\n" +
            "\"shortname\": \"sports-fitness\",\n" +
            "\"name\": \"Sports & Fitness\",\n" +
            "\"sort_name\": \"Sports & Fitness\",\n" +
            "\"photo\": {\n" +
            "\"id\": 450131948,\n" +
            "\"highres_link\": \"https://secure.meetupstatic.com/photos/event/2/e/a/c/highres_450131948.jpeg\",\n" +
            "\"photo_link\": \"https://secure.meetupstatic.com/photos/event/2/e/a/c/600_450131948.jpeg\",\n" +
            "\"thumb_link\": \"https://secure.meetupstatic.com/photos/event/2/e/a/c/thumb_450131948.jpeg\",\n" +
            "\"type\": \"event\",\n" +
            "\"base_url\": \"https://secure.meetupstatic.com\"\n" +
            "},\n" +
            "\"category_ids\": [\n" +
            "9,\n" +
            "32\n" +
            "]\n" +
            "},\n" +
            "\"5\": {\n" +
            "\"id\": 562,\n" +
            "\"shortname\": \"education\",\n" +
            "\"name\": \"Learning\",\n" +
            "\"sort_name\": \"Learning\",\n" +
            "\"photo\": {\n" +
            "\"id\": 450131931,\n" +
            "\"highres_link\": \"https://secure.meetupstatic.com/photos/event/2/e/9/b/highres_450131931.jpeg\",\n" +
            "\"photo_link\": \"https://secure.meetupstatic.com/photos/event/2/e/9/b/600_450131931.jpeg\",\n" +
            "\"thumb_link\": \"https://secure.meetupstatic.com/photos/event/2/e/9/b/thumb_450131931.jpeg\",\n" +
            "\"type\": \"event\",\n" +
            "\"base_url\": \"https://secure.meetupstatic.com\"\n" +
            "},\n" +
            "\"category_ids\": [\n" +
            "6\n" +
            "]\n" +
            "},\n" +
            "\"6\": {\n" +
            "\"id\": 262,\n" +
            "\"shortname\": \"photography\",\n" +
            "\"name\": \"Photography\",\n" +
            "\"sort_name\": \"Photography\",\n" +
            "\"photo\": {\n" +
            "\"id\": 450131946,\n" +
            "\"highres_link\": \"https://secure.meetupstatic.com/photos/event/2/e/a/a/highres_450131946.jpeg\",\n" +
            "\"photo_link\": \"https://secure.meetupstatic.com/photos/event/2/e/a/a/600_450131946.jpeg\",\n" +
            "\"thumb_link\": \"https://secure.meetupstatic.com/photos/event/2/e/a/a/thumb_450131946.jpeg\",\n" +
            "\"type\": \"event\",\n" +
            "\"base_url\": \"https://secure.meetupstatic.com\"\n" +
            "},\n" +
            "\"category_ids\": [\n" +
            "27\n" +
            "]\n" +
            "},\n" +
            "\"7\": {\n" +
            "\"id\": 162,\n" +
            "\"shortname\": \"food\",\n" +
            "\"name\": \"Food & Drink\",\n" +
            "\"sort_name\": \"Food & Drink\",\n" +
            "\"photo\": {\n" +
            "\"id\": 450131937,\n" +
            "\"highres_link\": \"https://secure.meetupstatic.com/photos/event/2/e/a/1/highres_450131937.jpeg\",\n" +
            "\"photo_link\": \"https://secure.meetupstatic.com/photos/event/2/e/a/1/600_450131937.jpeg\",\n" +
            "\"thumb_link\": \"https://secure.meetupstatic.com/photos/event/2/e/a/1/thumb_450131937.jpeg\",\n" +
            "\"type\": \"event\",\n" +
            "\"base_url\": \"https://secure.meetupstatic.com\"\n" +
            "},\n" +
            "\"category_ids\": [\n" +
            "10\n" +
            "]\n" +
            "},\n" +
            "\"8\": {\n" +
            "\"id\": 582,\n" +
            "\"shortname\": \"writing\",\n" +
            "\"name\": \"Writing\",\n" +
            "\"sort_name\": \"Writing\",\n" +
            "\"photo\": {\n" +
            "\"id\": 450131951,\n" +
            "\"highres_link\": \"https://secure.meetupstatic.com/photos/event/2/e/a/f/highres_450131951.jpeg\",\n" +
            "\"photo_link\": \"https://secure.meetupstatic.com/photos/event/2/e/a/f/600_450131951.jpeg\",\n" +
            "\"thumb_link\": \"https://secure.meetupstatic.com/photos/event/2/e/a/f/thumb_450131951.jpeg\",\n" +
            "\"type\": \"event\",\n" +
            "\"base_url\": \"https://secure.meetupstatic.com\"\n" +
            "},\n" +
            "\"category_ids\": [\n" +
            "36\n" +
            "]\n" +
            "},\n" +
            "\"9\": {\n" +
            "\"id\": 212,\n" +
            "\"shortname\": \"language\",\n" +
            "\"name\": \"Language & Culture\",\n" +
            "\"sort_name\": \"Language & Culture\",\n" +
            "\"photo\": {\n" +
            "\"id\": 450131939,\n" +
            "\"highres_link\": \"https://secure.meetupstatic.com/photos/event/2/e/a/3/highres_450131939.jpeg\",\n" +
            "\"photo_link\": \"https://secure.meetupstatic.com/photos/event/2/e/a/3/600_450131939.jpeg\",\n" +
            "\"thumb_link\": \"https://secure.meetupstatic.com/photos/event/2/e/a/3/thumb_450131939.jpeg\",\n" +
            "\"type\": \"event\",\n" +
            "\"base_url\": \"https://secure.meetupstatic.com\"\n" +
            "},\n" +
            "\"category_ids\": [\n" +
            "16\n" +
            "]\n" +
            "},\n" +
            "\"10\": {\n" +
            "\"id\": 512,\n" +
            "\"shortname\": \"music\",\n" +
            "\"name\": \"Music\",\n" +
            "\"sort_name\": \"Music\",\n" +
            "\"photo\": {\n" +
            "\"id\": 450131942,\n" +
            "\"highres_link\": \"https://secure.meetupstatic.com/photos/event/2/e/a/6/highres_450131942.jpeg\",\n" +
            "\"photo_link\": \"https://secure.meetupstatic.com/photos/event/2/e/a/6/600_450131942.jpeg\",\n" +
            "\"thumb_link\": \"https://secure.meetupstatic.com/photos/event/2/e/a/6/thumb_450131942.jpeg\",\n" +
            "\"type\": \"event\",\n" +
            "\"base_url\": \"https://secure.meetupstatic.com\"\n" +
            "},\n" +
            "\"category_ids\": [\n" +
            "21\n" +
            "]\n" +
            "},\n" +
            "\"11\": {\n" +
            "\"id\": 552,\n" +
            "\"shortname\": \"movements\",\n" +
            "\"name\": \"Movements\",\n" +
            "\"sort_name\": \"Movements\",\n" +
            "\"photo\": {\n" +
            "\"id\": 450131941,\n" +
            "\"highres_link\": \"https://secure.meetupstatic.com/photos/event/2/e/a/5/highres_450131941.jpeg\",\n" +
            "\"photo_link\": \"https://secure.meetupstatic.com/photos/event/2/e/a/5/600_450131941.jpeg\",\n" +
            "\"thumb_link\": \"https://secure.meetupstatic.com/photos/event/2/e/a/5/thumb_450131941.jpeg\",\n" +
            "\"type\": \"event\",\n" +
            "\"base_url\": \"https://secure.meetupstatic.com\"\n" +
            "},\n" +
            "\"category_ids\": [\n" +
            "4,\n" +
            "13\n" +
            "]\n" +
            "},\n" +
            "\"12\": {\n" +
            "\"id\": 585,\n" +
            "\"shortname\": \"lgbtq\",\n" +
            "\"name\": \"LGBTQ\",\n" +
            "\"sort_name\": \"LGBTQ\",\n" +
            "\"photo\": {\n" +
            "\"id\": 450131940,\n" +
            "\"highres_link\": \"https://secure.meetupstatic.com/photos/event/2/e/a/4/highres_450131940.jpeg\",\n" +
            "\"photo_link\": \"https://secure.meetupstatic.com/photos/event/2/e/a/4/600_450131940.jpeg\",\n" +
            "\"thumb_link\": \"https://secure.meetupstatic.com/photos/event/2/e/a/4/thumb_450131940.jpeg\",\n" +
            "\"type\": \"event\",\n" +
            "\"base_url\": \"https://secure.meetupstatic.com\"\n" +
            "},\n" +
            "\"category_ids\": [\n" +
            "12\n" +
            "]\n" +
            "},\n" +
            "\"13\": {\n" +
            "\"id\": 583,\n" +
            "\"shortname\": \"film\",\n" +
            "\"name\": \"Film\",\n" +
            "\"sort_name\": \"Film\",\n" +
            "\"photo\": {\n" +
            "\"id\": 450858495,\n" +
            "\"highres_link\": \"https://secure.meetupstatic.com/photos/event/4/8/3/f/highres_450858495.jpeg\",\n" +
            "\"photo_link\": \"https://secure.meetupstatic.com/photos/event/4/8/3/f/600_450858495.jpeg\",\n" +
            "\"thumb_link\": \"https://secure.meetupstatic.com/photos/event/4/8/3/f/thumb_450858495.jpeg\",\n" +
            "\"type\": \"event\",\n" +
            "\"base_url\": \"https://secure.meetupstatic.com\"\n" +
            "},\n" +
            "\"category_ids\": [\n" +
            "20\n" +
            "]\n" +
            "},\n" +
            "\"14\": {\n" +
            "\"id\": 182,\n" +
            "\"shortname\": \"games-sci-fi\",\n" +
            "\"name\": \"Sci-Fi & Games\",\n" +
            "\"sort_name\": \"Sci-Fi & Games\",\n" +
            "\"photo\": {\n" +
            "\"id\": 450131938,\n" +
            "\"highres_link\": \"https://secure.meetupstatic.com/photos/event/2/e/a/2/highres_450131938.jpeg\",\n" +
            "\"photo_link\": \"https://secure.meetupstatic.com/photos/event/2/e/a/2/600_450131938.jpeg\",\n" +
            "\"thumb_link\": \"https://secure.meetupstatic.com/photos/event/2/e/a/2/thumb_450131938.jpeg\",\n" +
            "\"type\": \"event\",\n" +
            "\"base_url\": \"https://secure.meetupstatic.com\"\n" +
            "},\n" +
            "\"category_ids\": [\n" +
            "11,\n" +
            "29\n" +
            "]\n" +
            "},\n" +
            "\"15\": {\n" +
            "\"id\": 132,\n" +
            "\"shortname\": \"beliefs\",\n" +
            "\"name\": \"Beliefs\",\n" +
            "\"sort_name\": \"Beliefs\",\n" +
            "\"photo\": {\n" +
            "\"id\": 450131925,\n" +
            "\"highres_link\": \"https://secure.meetupstatic.com/photos/event/2/e/9/5/highres_450131925.jpeg\",\n" +
            "\"photo_link\": \"https://secure.meetupstatic.com/photos/event/2/e/9/5/600_450131925.jpeg\",\n" +
            "\"thumb_link\": \"https://secure.meetupstatic.com/photos/event/2/e/9/5/thumb_450131925.jpeg\",\n" +
            "\"type\": \"event\",\n" +
            "\"base_url\": \"https://secure.meetupstatic.com\"\n" +
            "},\n" +
            "\"category_ids\": [\n" +
            "22,\n" +
            "24,\n" +
            "28\n" +
            "]\n" +
            "},\n" +
            "\"16\": {\n" +
            "\"id\": 122,\n" +
            "\"shortname\": \"arts-culture\",\n" +
            "\"name\": \"Arts\",\n" +
            "\"sort_name\": \"Arts\",\n" +
            "\"photo\": {\n" +
            "\"id\": 450131912,\n" +
            "\"highres_link\": \"https://secure.meetupstatic.com/photos/event/2/e/8/8/highres_450131912.jpeg\",\n" +
            "\"photo_link\": \"https://secure.meetupstatic.com/photos/event/2/e/8/8/600_450131912.jpeg\",\n" +
            "\"thumb_link\": \"https://secure.meetupstatic.com/photos/event/2/e/8/8/thumb_450131912.jpeg\",\n" +
            "\"type\": \"event\",\n" +
            "\"base_url\": \"https://secure.meetupstatic.com\"\n" +
            "},\n" +
            "\"category_ids\": [\n" +
            "1\n" +
            "]\n" +
            "},\n" +
            "\"17\": {\n" +
            "\"id\": 222,\n" +
            "\"shortname\": \"book-clubs\",\n" +
            "\"name\": \"Book Clubs\",\n" +
            "\"sort_name\": \"Book Clubs\",\n" +
            "\"photo\": {\n" +
            "\"id\": 450131926,\n" +
            "\"highres_link\": \"https://secure.meetupstatic.com/photos/event/2/e/9/6/highres_450131926.jpeg\",\n" +
            "\"photo_link\": \"https://secure.meetupstatic.com/photos/event/2/e/9/6/600_450131926.jpeg\",\n" +
            "\"thumb_link\": \"https://secure.meetupstatic.com/photos/event/2/e/9/6/thumb_450131926.jpeg\",\n" +
            "\"type\": \"event\",\n" +
            "\"base_url\": \"https://secure.meetupstatic.com\"\n" +
            "},\n" +
            "\"category_ids\": [\n" +
            "18\n" +
            "]\n" +
            "},\n" +
            "\"18\": {\n" +
            "\"id\": 542,\n" +
            "\"shortname\": \"dancing\",\n" +
            "\"name\": \"Dance\",\n" +
            "\"sort_name\": \"Dance\",\n" +
            "\"photo\": {\n" +
            "\"id\": 450131930,\n" +
            "\"highres_link\": \"https://secure.meetupstatic.com/photos/event/2/e/9/a/highres_450131930.jpeg\",\n" +
            "\"photo_link\": \"https://secure.meetupstatic.com/photos/event/2/e/9/a/600_450131930.jpeg\",\n" +
            "\"thumb_link\": \"https://secure.meetupstatic.com/photos/event/2/e/9/a/thumb_450131930.jpeg\",\n" +
            "\"type\": \"event\",\n" +
            "\"base_url\": \"https://secure.meetupstatic.com\"\n" +
            "},\n" +
            "\"category_ids\": [\n" +
            "5\n" +
            "]\n" +
            "},\n" +
            "\"19\": {\n" +
            "\"id\": 252,\n" +
            "\"shortname\": \"pets\",\n" +
            "\"name\": \"Pets\",\n" +
            "\"sort_name\": \"Pets\",\n" +
            "\"photo\": {\n" +
            "\"id\": 450131945,\n" +
            "\"highres_link\": \"https://secure.meetupstatic.com/photos/event/2/e/a/9/highres_450131945.jpeg\",\n" +
            "\"photo_link\": \"https://secure.meetupstatic.com/photos/event/2/e/a/9/600_450131945.jpeg\",\n" +
            "\"thumb_link\": \"https://secure.meetupstatic.com/photos/event/2/e/a/9/thumb_450131945.jpeg\",\n" +
            "\"type\": \"event\",\n" +
            "\"base_url\": \"https://secure.meetupstatic.com\"\n" +
            "},\n" +
            "\"category_ids\": [\n" +
            "26\n" +
            "]\n" +
            "},\n" +
            "\"20\": {\n" +
            "\"id\": 532,\n" +
            "\"shortname\": \"hobbies-crafts\",\n" +
            "\"name\": \"Hobbies & Crafts\",\n" +
            "\"sort_name\": \"Hobbies & Crafts\",\n" +
            "\"photo\": {\n" +
            "\"id\": 450131929,\n" +
            "\"highres_link\": \"https://secure.meetupstatic.com/photos/event/2/e/9/9/highres_450131929.jpeg\",\n" +
            "\"photo_link\": \"https://secure.meetupstatic.com/photos/event/2/e/9/9/600_450131929.jpeg\",\n" +
            "\"thumb_link\": \"https://secure.meetupstatic.com/photos/event/2/e/9/9/thumb_450131929.jpeg\",\n" +
            "\"type\": \"event\",\n" +
            "\"base_url\": \"https://secure.meetupstatic.com\"\n" +
            "},\n" +
            "\"category_ids\": [\n" +
            "15\n" +
            "]\n" +
            "},\n" +
            "\"21\": {\n" +
            "\"id\": 584,\n" +
            "\"shortname\": \"fashion-beauty\",\n" +
            "\"name\": \"Fashion & Beauty\",\n" +
            "\"sort_name\": \"Fashion & Beauty\",\n" +
            "\"photo\": {\n" +
            "\"id\": 450131934,\n" +
            "\"highres_link\": \"https://secure.meetupstatic.com/photos/event/2/e/9/e/highres_450131934.jpeg\",\n" +
            "\"photo_link\": \"https://secure.meetupstatic.com/photos/event/2/e/9/e/600_450131934.jpeg\",\n" +
            "\"thumb_link\": \"https://secure.meetupstatic.com/photos/event/2/e/9/e/thumb_450131934.jpeg\",\n" +
            "\"type\": \"event\",\n" +
            "\"base_url\": \"https://secure.meetupstatic.com\"\n" +
            "},\n" +
            "\"category_ids\": [\n" +
            "8\n" +
            "]\n" +
            "},\n" +
            "\"22\": {\n" +
            "\"id\": 272,\n" +
            "\"shortname\": \"social\",\n" +
            "\"name\": \"Social\",\n" +
            "\"sort_name\": \"Social\",\n" +
            "\"photo\": {\n" +
            "\"id\": 450131947,\n" +
            "\"highres_link\": \"https://secure.meetupstatic.com/photos/event/2/e/a/b/highres_450131947.jpeg\",\n" +
            "\"photo_link\": \"https://secure.meetupstatic.com/photos/event/2/e/a/b/600_450131947.jpeg\",\n" +
            "\"thumb_link\": \"https://secure.meetupstatic.com/photos/event/2/e/a/b/thumb_450131947.jpeg\",\n" +
            "\"type\": \"event\",\n" +
            "\"base_url\": \"https://secure.meetupstatic.com\"\n" +
            "},\n" +
            "\"category_ids\": [\n" +
            "31\n" +
            "]\n" +
            "},\n" +
            "\"23\": {\n" +
            "\"id\": 522,\n" +
            "\"shortname\": \"career-business\",\n" +
            "\"name\": \"Career & Business\",\n" +
            "\"sort_name\": \"Career & Business\",\n" +
            "\"photo\": {\n" +
            "\"id\": 450131927,\n" +
            "\"highres_link\": \"https://secure.meetupstatic.com/photos/event/2/e/9/7/highres_450131927.jpeg\",\n" +
            "\"photo_link\": \"https://secure.meetupstatic.com/photos/event/2/e/9/7/600_450131927.jpeg\",\n" +
            "\"thumb_link\": \"https://secure.meetupstatic.com/photos/event/2/e/9/7/thumb_450131927.jpeg\",\n" +
            "\"type\": \"event\",\n" +
            "\"base_url\": \"https://secure.meetupstatic.com\"\n" +
            "},\n" +
            "\"category_ids\": [\n" +
            "2\n" +
            "]\n" +
            "}\n" +
            "}";
    public static ArrayList<Category> getCategories(){
        ArrayList<Category> res = new ArrayList<>();
        try {
            JSONObject json = new JSONObject(sCategories);
            int size = json.length();
            for(int i = 0; i < size; i++){
                String key = i + "";
                JSONObject j = json.optJSONObject(key);
                Category c = new Category();
                c.fromJson(j);
                res.add(c);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return res;
    }
}
