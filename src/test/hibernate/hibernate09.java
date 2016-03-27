package test.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import main.src.entity.Genre;
import main.src.entity.Opus;
import main.src.service.GenreService;
import main.src.service.OpusService;

public class hibernate09 {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new FileSystemXmlApplicationContext(
				new String[]{"C:/Users/Administrator/git/iBlog/WebContent/WEB-INF/applicationContext.xml"
						,"C:/Users/Administrator/git/iBlog/WebContent/WEB-INF/daoContext.xml"
				});
		OpusService os = ctx.getBean("opusService",OpusService.class);
		GenreService gs = ctx.getBean("genreService",GenreService.class);
		Opus o = os.get(34);
		Genre g = new Genre();
		g.setId(4);
		o.getGenres().clear();;
		o.getGenres().add(g);
		os.update(o);
	}

}
