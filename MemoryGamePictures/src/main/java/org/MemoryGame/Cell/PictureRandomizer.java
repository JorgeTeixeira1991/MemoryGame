package org.MemoryGame.Cell;


import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.ArrayList;
import java.util.List;

public class PictureRandomizer {

    private List<String> pictureList;
    String filePath;

    public PictureRandomizer() {
        this.pictureList = new ArrayList<>();
        populatePictureList();
    }

    private enum Pictures {
        CAT1(ImageFilePaths.cat1), CAT2(ImageFilePaths.cat2), CAT3(ImageFilePaths.cat3), CAT4(ImageFilePaths.cat4),
        CAT5(ImageFilePaths.cat5), CAT6(ImageFilePaths.cat6), CAT7(ImageFilePaths.cat7), CAT8(ImageFilePaths.cat8);
        private String picture;

        Pictures(String picture) {
            this.picture = picture;
        }

        private String getPicture() {
            return picture;
        }
    }

    public void populatePictureList() {
        Pictures[] pictures = Pictures.values();
        List<String> copy;
        for (Pictures p : pictures) {
            pictureList.add(p.getPicture());
        }
        copy = List.copyOf(pictureList);
        pictureList.addAll(copy);
        System.out.println(pictureList);
    }


    public Picture randomizePicture() {
        int random = (int) (Math.random() * pictureList.size());
        filePath = pictureList.get(random);
        Picture picture = new Picture(0,0, filePath);
        try {
            return picture;
        }finally {
            pictureList.remove(filePath);
        }
    }

    public String getFilePath(){
        return filePath;
    }
}
