// ### Groovy Sample ###

import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.journal.model.JournalArticle;
import java.util.List;


List<Organization> organizationList = OrganizationLocalServiceUtil.getOrganizations(QueryUtil.ALL_POS,QueryUtil.ALL_POS); 

for(int i=0; i<organizationList.size();i++)
{
  Organization orga = organizationList.get(i);
  Group group = orga.getGroup();
  out.println(orga.getGroup().getDescriptiveName());
  List<Layout> rootLayoutsPrivate  = LayoutLocalServiceUtil.getLayouts(group.getGroupId(), true);
  for(Layout currentLayout:rootLayoutsPrivate)
  {
       out.println(currentLayout.getName());
  }
  List<Layout> rootLayoutsPublic  = LayoutLocalServiceUtil.getLayouts(group.getGroupId(), false);
  for(Layout currentLayout:rootLayoutsPublic)
  {
       out.println(currentLayout.getName());
  }
  List<JournalArticle> articleList = JournalArticleLocalServiceUtil.getArticles(group.getGroupId());
  for(JournalArticle article:articleList)
  {
     out.println(article.getTitle());
  }
}
