package emlakburada.dto.request;

import lombok.Data;

@Data
public class UserRequest {

    private String kullaniciTipi; // bireysel & kurumsal & yeniTip
    private String isim;
    private String email;
    private String fotograf;
    private String biyografi;
    private String password;
}
