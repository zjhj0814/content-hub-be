package tibetyo.content_hub.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tibetyo.content_hub.dto.content.ContentDetailDto;
import tibetyo.content_hub.dto.content.ContentResponseDto;
import tibetyo.content_hub.dto.content.ContentSummaryDto;
import tibetyo.content_hub.entity.Content;
import tibetyo.content_hub.entity.ContentCategory;
import tibetyo.content_hub.exception.CustomException;
import tibetyo.content_hub.exception.ErrorCode;
import tibetyo.content_hub.repository.LikeRepository;
import tibetyo.content_hub.repository.content.ContentRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class ContentService {
    private final ContentRepository contentRepository;
    private final LikeRepository likeRepository;

    public ContentService(ContentRepository contentRepository, LikeRepository likeRepository) {
        this.contentRepository = contentRepository;
        this.likeRepository = likeRepository;
    }

    public ContentDetailDto getContentDetail(Long contentId) {
        Content content = contentRepository.findContentAndCastByContentId(contentId)
                .orElseThrow(() -> new CustomException(ErrorCode.CONTENT_NOT_FOUND));
        ContentDetailDto contentDetailDto = ContentDetailDto.of(content);
        contentDetailDto.setLikes(likeRepository.countLikesByContentId(contentId));
        return contentDetailDto;
    }

    public List<ContentSummaryDto> findContentByTitle(String title) {
        List<Content> contents = contentRepository.findContentsByTitle(title);
        return contents.stream().map(ContentSummaryDto::of).collect(Collectors.toList());
    }

    public List<ContentSummaryDto> findContentByCategory(ContentCategory category) {
        List<Content> contents = contentRepository.findContentsByCategory(category);
        return contents.stream().map(ContentSummaryDto::of).collect(Collectors.toList());
    }

    public List<ContentSummaryDto> findContentByCast(String castName) {
        List<Content> contents = contentRepository.findContentsByCastName(castName.strip());
        return contents.stream().map(ContentSummaryDto::of).collect(Collectors.toList());
    }

    public List<ContentResponseDto> findContentsByLikes() {
        List<Content> contents = contentRepository.findContentsOrderByLikes();
        return contents.stream().map(ContentResponseDto::of).collect(Collectors.toList());
    }
}
