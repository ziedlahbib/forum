package com.pidev.backend.Service;

import com.pidev.backend.Entity.FileDB;
import com.pidev.backend.Entity.Reponse;
import com.pidev.backend.Repository.FileDBRepository;
import com.pidev.backend.Repository.ReponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


@Service
public class FileStorageService {
	Long idf;
  @Autowired
  private FileDBRepository fileDBRepo;

  @Autowired
  ReponseRepository reponserepo;

  public List<String> store(List<MultipartFile> file) throws IOException {
	  List<String> ls=new ArrayList<String>();
	  for(MultipartFile f:file){
		  String fileName = StringUtils.cleanPath(f.getOriginalFilename());
		  FileDB FileDB = new FileDB(fileName, f.getContentType(), f.getBytes());
		  fileDBRepo.save(FileDB);
		   ls.add(FileDB.getId());
	  }
	  return ls;
	  }
  public void deletefile(String idfile) {
	  FileDB f =fileDBRepo.findById(idfile).orElse(null);
	  fileDBRepo.delete(f);
  }
  public FileDB getFile(String id) {
    return fileDBRepo.findById(id).orElse(null);
  }
  
  
  public Stream<FileDB> getAllFiles() {
    return fileDBRepo.findAll().stream();
  }

  public List<FileDB> getFileByReponse(String id) {
	  Reponse t =reponserepo.findById(id).orElse(null);
	    return t.getFiles();
	  }
  public void affecterFileToReponse(List<String> idFiles, String idReponse) {
		Reponse t=reponserepo.findById(idReponse).orElse(null);

		for(String s: idFiles){
			FileDB f=fileDBRepo.findById(s).orElse(null);
			if(t.getFiles()==null){
				List<FileDB> lfs=new ArrayList<FileDB>();
				lfs.add(f);
				t.setFiles(lfs);
				reponserepo.save(t);
			}else{
				t.getFiles().add(f);
				reponserepo.save(t);
			}


		}


	}


 
}