package matchTeam.crewcrew.service.chat;

import lombok.RequiredArgsConstructor;
import matchTeam.crewcrew.dto.chat.ChatMessageResponseDTO;
import matchTeam.crewcrew.entity.chat.ChatMessage;
import matchTeam.crewcrew.entity.chat.ChatRoom;
import matchTeam.crewcrew.entity.user.test.Member;
import matchTeam.crewcrew.repository.chat.ChatMessageRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ChatMessageService {
    private final ChatMessageRepository chatMessageRepository;
    private final ChatRoomService chatRoomService;

    public List<ChatMessageResponseDTO> saveMessage(ChatRoom room, Member member, String content) {
        ChatMessage message = ChatMessage.builder().member(member).chatRoom(room).content(content).build();
        message.setReadCnt(1);
        chatMessageRepository.save(message);
        List<ChatMessage> messages = new ArrayList<>();
        messages.add(message);

        List<ChatMessageResponseDTO> result = chatRoomService.messageToResponse(room.getRoomId(), messages);


        return result;
    }


//    public List<ChatMessage> findChatByMember(){
//
//    }

}
