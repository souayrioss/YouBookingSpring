package org.roronoa.youbooking.util;


import org.modelmapper.ModelMapper;
import org.roronoa.youbooking.dto.UserAppDto;
import org.roronoa.youbooking.entity.UserApp;


import java.security.SecureRandom;

import static org.roronoa.youbooking.util.IConstantes.CAPS;
import static org.roronoa.youbooking.util.IConstantes.LENGTH;


public class EntityUtils {

    private static final SecureRandom random = new SecureRandom();



    public static String generateReference() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < LENGTH; i++) {
            int index = random.nextInt(CAPS.length());
            result.append(CAPS.charAt(index));
        }
        return result.toString();
    }



    public static UserAppDto userToUserDTO(UserApp user) {
        ModelMapper modelMapper=new ModelMapper();
        return modelMapper.map(user, UserAppDto.class);
    }
    public static UserApp userDTOToUser(UserAppDto userAppDto) {
        ModelMapper modelMapper=new ModelMapper();
        return modelMapper.map(userAppDto, UserApp.class);
    }


}
