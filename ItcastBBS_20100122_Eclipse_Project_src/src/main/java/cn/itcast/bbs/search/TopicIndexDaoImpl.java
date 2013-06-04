package cn.itcast.bbs.search;

import org.compass.core.CompassHits;
import org.springframework.stereotype.Repository;

import cn.itcast.bbs.domain.SearchableTopic;
import cn.itcast.bbs.search.base.GenericIndexDaoImpl;

@Repository("topicIndexDao")
public class TopicIndexDaoImpl extends GenericIndexDaoImpl<SearchableTopic> {

	public TopicIndexDaoImpl() {
		super(SearchableTopic.class);
	}

	@Override
	protected SearchableTopic hit2Object(CompassHits hits, int index) {
		SearchableTopic st = (SearchableTopic) hits.data(index);

		// 高亮title
		String text = hits.highlighter(index).fragment("title");
		if (text == null && st.getTitle().length() > defaultFragmentSize) {
			text = st.getTitle().substring(0, defaultFragmentSize);
		}
		if (text != null) {
			st.setTitle(text);
		}

		// 高亮content
		text = hits.highlighter(index).fragment("content");
		if (text == null && st.getContent().length() > defaultFragmentSize) {
			text = st.getContent().substring(0, defaultFragmentSize);
		}
		if (text != null) {
			st.setContent(text);
		}

		return st;
	}

	// @Override
	// protected SearchableTopic hit2Object(CompassHit hit) {
	// SearchableTopic st = (SearchableTopic) hit.data();
	// String text = hit.getHighlightedText().getHighlightedText("content");
	// if (text == null && st.getContent().length() > defaultFragmentSize) {
	// text = st.getContent().substring(0, defaultFragmentSize);
	// }
	// if (text != null) {
	// st.setContent(text);
	// }
	//
	// return st;
	// }

}
