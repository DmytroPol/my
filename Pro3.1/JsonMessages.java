package ua.kiev.prog;

import java.util.ArrayList;
import java.util.List;

public class JsonMessages {
    private final List<Message> list;

    public JsonMessages(List<Message> sourceList, int fromIndex) {
//        ChatRooms chatRooms = ChatRooms.getInstance(); //Serg
        this.list = new ArrayList<>();
        for (int i = fromIndex; i < sourceList.size(); i++)
//            if ((sourceList.get(i).getTo() == null) ||
//                    (sourceList.get(i).getTo().equals(forUser)) ||
//                    ((sourceList.get(i).getFrom().equals(forUser))&&(sourceList.get(i).getTo()!=null)) ||
//                    (chatRooms.userIsInRoom(forUser,sourceList.get(i).getRoom()))
//                    ) {  //Serg
            list.add(sourceList.get(i));
        }
    }
//            else {
//                list.add(null);
//            }
//    }
//}