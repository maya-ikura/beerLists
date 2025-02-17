package model;

import java.io.File;

import dao.BeersDAO;

public class DeleteImageLogic {
	 // 画像削除メソッド
    public boolean deleteImage(String beerImage) {
        // 画像のパスを指定して File オブジェクトを作成
    	String uploadPath = "C:\\pleiades\\2023-12\\workspace\\beerLists\\src\\main\\webapp\\img";
        File imageFile = new File(uploadPath + File.separator + beerImage);

        // ファイルが存在するか確認
        if (imageFile.exists()) {
            // ファイルを削除
         if (imageFile.delete()) {
        	 BeersDAO dao = new BeersDAO();
        	 boolean isDelete = dao.deleteImg(beerImage);
        	 if(isDelete) {
                return true; // 削除成功
            } else {
                return false; // 削除失敗
            }
         }
        }
		return false;
    }
    
}

        


