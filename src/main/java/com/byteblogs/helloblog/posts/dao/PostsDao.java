package com.byteblogs.helloblog.posts.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.byteblogs.common.base.dao.BaseDao;
import com.byteblogs.helloblog.posts.domain.po.Posts;
import com.byteblogs.helloblog.posts.domain.vo.PostsVO;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author byteblogs
 * @since 2019-08-28
 */
public interface PostsDao extends BaseDao<Posts> {

    /**
     * 查询文章列表
     * @param page
     * @param localDateTime
     * @param keywords
     * @return
     */
    List<PostsVO> selectPostsList(Page<PostsVO> page, @Param("archiveDate") LocalDateTime localDateTime, @Param("keywords") String keywords);

    /**
     * 看板统计
     * @return
     */
    PostsVO selectPostsTotal();

    /**
     * 按照时间进行归档统计某个时间有多个文章
     * @return
     */
    List<PostsVO> selectArchiveTotalGroupDateList();

    /**
     * 按照年维度查询带有文章标题的归档列表
     * @return
     */
    List<PostsVO> selectArchiveGroupYearList();

    /**
     * 自增浏览量
     * @param id
     * @return
     */
    int incrementView(@Param("id") Long id);

    /**
     * 自增评论量
     * @param id
     * @return
     */
    int incrementComments(@Param("id") Long id);
}
