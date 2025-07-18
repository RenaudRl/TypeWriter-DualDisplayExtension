package btc.renaud.dualtextdisplayextension.entries.definition

import com.typewritermc.core.books.pages.Colors
import com.typewritermc.core.entries.Ref
import com.typewritermc.core.entries.emptyRef
import com.typewritermc.core.extension.annotations.Entry
import com.typewritermc.core.extension.annotations.OnlyTags
import com.typewritermc.core.extension.annotations.Help
import com.typewritermc.core.extension.annotations.Default
import com.typewritermc.core.extension.annotations.Tags
import com.typewritermc.core.utils.point.Position
import com.typewritermc.engine.paper.entry.entity.FakeEntity
import com.typewritermc.engine.paper.entry.entity.SimpleEntityDefinition
import com.typewritermc.engine.paper.entry.entries.*
import com.typewritermc.engine.paper.utils.Sound
import com.typewritermc.entity.entries.entity.minecraft.TextDisplayDefinition
import com.typewritermc.entity.entries.entity.minecraft.TextDisplayEntity
import org.bukkit.entity.Player

@Tags("dual_text_display_definition", "entity_definition")
@Entry(
    "dual_text_display_definition", 
    "A text display definition specifically designed for dual text display with focus camera functionality", 
    Colors.ORANGE, 
    "material-symbols:text-ad-rounded"
)
class DualTextDisplayDefinition(
    override val id: String = "",
    override val name: String = "",
    override val displayName: Var<String> = ConstVar(""),
    override val sound: Sound = Sound.EMPTY,
    @OnlyTags("generic_entity_data", "display_data", "lines", "text_display_data")
    override val data: List<Ref<EntityData<*>>> = emptyList()
) : SimpleEntityDefinition {
    override fun create(player: Player): FakeEntity = DualTextDisplayEntity(player)
}

class DualTextDisplayEntity(
    player: Player,
    private val isFocusTarget: Boolean = false
) : TextDisplayEntity(player) {
    
    // Cette entité peut être identifiée comme une cible de focus
    fun isFocusTarget(): Boolean = isFocusTarget
    
    // Méthodes spécifiques pour le focus camera
    fun getFocusPosition(): Position? {
        // Retourne la position pour le focus camera
        return if (isFocusTarget) {
            // Position spécifique pour le focus
            Position.ORIGIN // À remplacer par la vraie position
        } else {
            null
        }
    }
}
