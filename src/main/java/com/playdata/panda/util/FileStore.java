package com.playdata.panda.util;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collector;
import org.springframework.web.multipart.MultipartFile;
import com.playdata.panda.dto.Certificate;
/**
 * FileStore
 * @author Playdata
 * 기능 : 파일 정보를 저장할 수 있습니다.
 */
public class FileStore {
	
	private final String uploadDir = Paths.get("C:", "teacher-change", "certificate").toString();// 파일 저장 경로
	
	// 비즈니스 메서드
	/**
	 * 기능 : 파일 리스트를 저장할 수 있습니다.
	 * @param files
	 * @return
	 */
	public List<Certificate> saveFileList(List<MultipartFile> files) {
	
		List<Certificate> certificateList = new ArrayList<>();
		for(MultipartFile file : files) {
			
			Certificate certificate = saveFile(file);
			certificateList.add(certificate);
		}
		
		return certificateList;
	 }
	
	/**
	 * 기능 : 파일을 저장할 수 있습니다.
	 * @param file
	 * @return
	 */
	private Certificate saveFile(MultipartFile file) {
		// 원본 파일이름 불러오기
		String orginalFileName = file.getOriginalFilename();
		// 저장된 파일 이름
		String savedFileName = printStoredFileName(orginalFileName);
		// 파일 경로명
		String fileFullPath = Paths.get(uploadDir, savedFileName).toString();
		
		// 폴더 생성하기
		File dir = new File(uploadDir);
		if(dir.exists() == false) {
			// 없는 폴더까지 생산하기
			dir.mkdirs();
		}
		
		// 파일 해당 폴더에 저장하기
		File saveFile = new File(fileFullPath);
		
		try {
			file.transferTo(saveFile);
			
		} catch (IOException e) {
			String errorMsg = "증명서 파일 저장 중 에러 발생!";
			throw new RuntimeException(errorMsg);
		}
		
		// 증명서 생성하기
		return Certificate.creaet(orginalFileName, savedFileName);
	}
	/**
	 * 기능 : 저장될 파일 이름을 찾을 수 있습니다.
	 * @param orginalFileName
	 */
	private String printStoredFileName(String orginalFileName) {
		int startPoint = orginalFileName.lastIndexOf(".") + 1;
		String ext = orginalFileName.substring(startPoint);
		
		String randomUuid = UUID.randomUUID().toString();
		String storedFileName = randomUuid + "." + ext;
		
		return storedFileName;
	}
		
}