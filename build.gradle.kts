
import myaa.subkt.ass.*
import myaa.subkt.tasks.*
import myaa.subkt.tasks.Mux.*
import myaa.subkt.tasks.Nyaa.*
import java.awt.Color
import java.time.*

plugins {
    id("myaa.subkt")
}

subs {
    readProperties("sub.properties")
    episodes(getList("episodes"))
    mux {
        title(get("title"))

        from(get("premux")) {
            video {
			    name("[Seicher-Raws]")
                lang("jpn")
                default(true)
            }
			subtitles { include(false) }
            audio { include(false) }
			includeChapters(false)
            attachments { include(false) }

        }
		from(get("audio")) {
            audio {
                name("")
				lang("jpn")
                default(true)
        }}
        from(get("subs")) {
            tracks {
                lang("eng")
                name(get("subtitles_full"))
                default(true)
                forced(false)
            }
        }

        chapters(get("chapters"))

        attach(get("fonts")) {
            includeExtensions("ttf", "otf")
        }
		attach(get("common_fonts")) { includeExtensions("ttf", "otf") }
		onMissingGlyphs(ErrorMode.IGNORE)
        out(get("muxout"))
    }


}
