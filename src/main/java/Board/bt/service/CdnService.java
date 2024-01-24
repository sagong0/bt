package Board.bt.service;

import Board.bt.domain.Member;
import lombok.RequiredArgsConstructor;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CdnService {
    public String fileUpload(MultipartFile image) {
        FTPClient ftp = new FTPClient();
        String url = "";
        String extension = StringUtils.getFilenameExtension(image.getOriginalFilename());
        ftp.setControlEncoding("utf-8");
        //String filename = image.getOriginalFilename();
        FTPClientConfig ftpConfig = new FTPClientConfig();
        UUID uuid = UUID.randomUUID();
        try {
            String host = "iup.cdn1.cafe24.com";
            String user = "wjswjdgh123";
            String pass = "qlalfqjsgh1@";
            int port = 21;
            ftp.configure(ftpConfig);
            ftp.connect(host, port);
            if (ftp.login(user, pass)) {
                ftp.setFileType(FTP.BINARY_FILE_TYPE);
                boolean result = ftp.storeFile("/www/img/" + uuid + "." + extension, image.getInputStream());
                if (result) {
                    url = "http://wjswjdgh123.cdn1.cafe24.com/img/" + uuid + "." + extension;
                    return url;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
      return "";
    }
}
