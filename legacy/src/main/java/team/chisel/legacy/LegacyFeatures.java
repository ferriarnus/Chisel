package team.chisel.legacy;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.tterrag.registrate.providers.RegistrateLangProvider;
import com.tterrag.registrate.providers.loot.RegistrateBlockLootTables;
import com.tterrag.registrate.util.entry.BlockEntry;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.ForgeRegistries;
import team.chisel.Features;
import team.chisel.api.block.ChiselBlockFactory;
import team.chisel.client.data.ModelTemplates;
import team.chisel.common.Reference;
import team.chisel.common.block.BlockCarvable;
import team.chisel.common.block.BlockCarvableBookshelf;
import team.chisel.common.block.BlockCarvablePane;

public class LegacyFeatures {

	private static final ChiselBlockFactory _FACTORY = ChiselBlockFactory.newFactory(ChiselLegacy.registrate());

    public static final Map<String, BlockEntry<BlockCarvable>> DIRT = _FACTORY.newType(Material.DIRT, "dirt")
            .addBlock(Blocks.DIRT)
            .applyTag(BlockTags.MINEABLE_WITH_SHOVEL)
            .variation("bricks")
            .next("netherbricks")
            .next("bricks3")
            .next("cobble")
            .next("reinforcedcobbledirt")
            .next("reinforceddirt")
            .next("happy")
            .next("bricks2")
            .next("bricks_dirt2")
            .next("hor")
                .model(ModelTemplates.cubeColumn("hor-ctmh", "hor-top"))
            .next("vert")
            .next("layers")
            .next("vertical")
            .next("chunky")
            .next("horizontal")
            .next("plate")
            .build(b -> b.strength(0.5F, 0.0F).sound(SoundType.GRAVEL));

    public static final Map<String, BlockEntry<BlockCarvable>> GLASS = _FACTORY.newType(Material.GLASS, "glass")
            .addBlock(Blocks.GLASS)
            .addTag(Tags.Blocks.GLASS)
            .addTag(Tags.Blocks.GLASS_COLORLESS)
            .initialProperties(() -> Blocks.GLASS)
            .variation("terrain_glassbubble")
//            .next("chinese")
            .next("japanese")
            .next("terrain_glassdungeon")
            .next("terrain_glasslight")
            .next("terrain_glassnoborder")
            .next("terrain_glass_ornatesteel")
            .next("terrain_glass_screen")
            .next("terrain_glassshale")
            .next("terrain_glass_steelframe")
            .next("terrain_glassstone")
            .next("terrain_glassstreak")
            .next("terrain_glass_thickgrid")
            .next("terrain_glass_thingrid")
            .next("a1_glasswindow_ironfencemodern")
            .next("chrono")
            .next("chinese2")
            .next("japanese2")
            .build(b -> b.sound(SoundType.GLASS).explosionResistance(0.3F));

    public static final Map<String, BlockEntry<BlockCarvablePane>> GLASSPANE = _FACTORY.newType(Material.GLASS, "glasspane", BlockCarvablePane::new)
            .addBlock(Blocks.GLASS_PANE)
            .addTag(Tags.Blocks.GLASS)
            .addTag(Tags.Blocks.GLASS_COLORLESS)
            .initialProperties(() -> Blocks.GLASS)
            .variation("terrain_glassbubble")
            .model(ModelTemplates.paneBlockCTM("block/glass/edge"))
            .itemModel((ctx, prov) -> prov.withExistingParent("item/" + prov.name(ctx::getEntry), new ResourceLocation("item/generated")).texture("layer0", "block/" + prov.name(ctx::getEntry).replaceFirst("pane", "")))
//            .next("chinese")
//                .model(ModelTemplates.paneblock("block/glass/chinese-top"))
//                .itemModel((ctx, prov) -> prov.withExistingParent("item/" + prov.name(ctx::getEntry), new ResourceLocation("item/generated")).texture("layer0", "block/" + prov.name(ctx::getEntry).replaceFirst("pane", "")))
            .next("japanese")
            .model(ModelTemplates.paneBlock("block/glass/japanese-top"))
            .itemModel((ctx, prov) -> prov.withExistingParent("item/" + prov.name(ctx::getEntry), new ResourceLocation("item/generated")).texture("layer0", "block/" + prov.name(ctx::getEntry).replaceFirst("pane", "")))
            .next("terrain_glassdungeon")
            .model(ModelTemplates.paneBlock("block/glass/edge_steel"))
            .itemModel((ctx, prov) -> prov.withExistingParent("item/" + prov.name(ctx::getEntry), new ResourceLocation("item/generated")).texture("layer0", "block/" + prov.name(ctx::getEntry).replaceFirst("pane", "")))
            .next("terrain_glasslight")
            .model(ModelTemplates.paneBlockCTM("block/glass/edge"))
            .itemModel((ctx, prov) -> prov.withExistingParent("item/" + prov.name(ctx::getEntry), new ResourceLocation("item/generated")).texture("layer0", "block/" + prov.name(ctx::getEntry).replaceFirst("pane", "")))
            .next("terrain_glassnoborder")
            .model(ModelTemplates.paneBlockCTM("block/glass/edge"))
            .itemModel((ctx, prov) -> prov.withExistingParent("item/" + prov.name(ctx::getEntry), new ResourceLocation("item/generated")).texture("layer0", "block/" + prov.name(ctx::getEntry).replaceFirst("pane", "")))
            .next("terrain_glass_ornatesteel")
            .model(ModelTemplates.paneBlockCTM("block/glass/edge_steel"))
            .itemModel((ctx, prov) -> prov.withExistingParent("item/" + prov.name(ctx::getEntry), new ResourceLocation("item/generated")).texture("layer0", "block/" + prov.name(ctx::getEntry).replaceFirst("pane", "")))
            .next("terrain_glass_screen")
            .model(ModelTemplates.paneBlock("block/glass/terrain_glass_screen"))
            .itemModel((ctx, prov) -> prov.withExistingParent("item/" + prov.name(ctx::getEntry), new ResourceLocation("item/generated")).texture("layer0", "block/" + prov.name(ctx::getEntry).replaceFirst("pane", "")))
            .next("terrain_glassshale")
            .model(ModelTemplates.paneBlockCTM("block/glass/edge_steel"))
            .itemModel((ctx, prov) -> prov.withExistingParent("item/" + prov.name(ctx::getEntry), new ResourceLocation("item/generated")).texture("layer0", "block/" + prov.name(ctx::getEntry).replaceFirst("pane", "")))
            .next("terrain_glass_steelframe")
            .model(ModelTemplates.paneBlockCTM("block/glass/edge_steel"))
            .itemModel((ctx, prov) -> prov.withExistingParent("item/" + prov.name(ctx::getEntry), new ResourceLocation("item/generated")).texture("layer0", "block/" + prov.name(ctx::getEntry).replaceFirst("pane", "")))
            .next("terrain_glassstone")
            .model(ModelTemplates.paneBlockCTM("block/glass/edge_steel"))
            .itemModel((ctx, prov) -> prov.withExistingParent("item/" + prov.name(ctx::getEntry), new ResourceLocation("item/generated")).texture("layer0", "block/" + prov.name(ctx::getEntry).replaceFirst("pane", "")))
            .next("terrain_glassstreak")
            .model(ModelTemplates.paneBlock("block/glass/terrain_glassstreak-top"))
            .itemModel((ctx, prov) -> prov.withExistingParent("item/" + prov.name(ctx::getEntry), new ResourceLocation("item/generated")).texture("layer0", "block/" + prov.name(ctx::getEntry).replaceFirst("pane", "")))
            .next("terrain_glass_thickgrid")
            .model(ModelTemplates.paneBlock("block/glass/terrain_glass_thickgrid"))
            .itemModel((ctx, prov) -> prov.withExistingParent("item/" + prov.name(ctx::getEntry), new ResourceLocation("item/generated")).texture("layer0", "block/" + prov.name(ctx::getEntry).replaceFirst("pane", "")))
            .next("terrain_glass_thingrid")
            .model(ModelTemplates.paneBlock("block/glass/terrain_glass_thingrid"))
            .itemModel((ctx, prov) -> prov.withExistingParent("item/" + prov.name(ctx::getEntry), new ResourceLocation("item/generated")).texture("layer0", "block/" + prov.name(ctx::getEntry).replaceFirst("pane", "")))
            .next("a1_glasswindow_ironfencemodern")
            .model(ModelTemplates.paneBlock("block/glass/edge_steel"))
            .itemModel((ctx, prov) -> prov.withExistingParent("item/" + prov.name(ctx::getEntry), new ResourceLocation("item/generated")).texture("layer0", "block/" + prov.name(ctx::getEntry).replaceFirst("pane", "")))
            .next("chrono")
            .model(ModelTemplates.paneBlockCTM("block/glass/edge_steel"))
            .itemModel((ctx, prov) -> prov.withExistingParent("item/" + prov.name(ctx::getEntry), new ResourceLocation("item/generated")).texture("layer0", "block/" + prov.name(ctx::getEntry).replaceFirst("pane", "")))
            .next("chinese2")
            .model(ModelTemplates.paneBlock("block/glass/chinese2-top"))
            .itemModel((ctx, prov) -> prov.withExistingParent("item/" + prov.name(ctx::getEntry), new ResourceLocation("item/generated")).texture("layer0", "block/" + prov.name(ctx::getEntry).replaceFirst("pane", "")))
            .next("japanese2")
            .model(ModelTemplates.paneBlock("block/glass/japanese2-top"))
            .itemModel((ctx, prov) -> prov.withExistingParent("item/" + prov.name(ctx::getEntry), new ResourceLocation("item/generated")).texture("layer0", "block/" + prov.name(ctx::getEntry).replaceFirst("pane", "")))
            .build(b -> b.sound(SoundType.GLASS).explosionResistance(0.3F));

    public static Map<DyeColor, Map<String, BlockEntry<BlockCarvable>>> GLASS_STAINED = Arrays.stream(DyeColor.values())
            .collect(Collectors.toMap(Function.identity(), color -> _FACTORY.newType(Material.GLASS, "glass_stained/" + color.getSerializedName())
                    .addBlock(new ResourceLocation(color.getSerializedName() + "_stained_glass"))
                    .setGroupName(RegistrateLangProvider.toEnglishName(color.getSerializedName()) + " Stained Glass")
                    .initialProperties(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(color.getSerializedName() + "_stained_glass")))
                    .addTag(Tags.Blocks.GLASS)
                    .addTag(BlockTags.create(new ResourceLocation("forge", "glass_" + color.getSerializedName())))
                    .variation("panel")
                    .next("framed")
                    .model(ModelTemplates.cubeCTMTranslusent("block/glass_stained/" + color.getSerializedName() + "/framed", "block/glass_stained/" + color.getSerializedName() + "/framed-ctm"))
                    .next("framed_fancy")
                    .model(ModelTemplates.cubeCTMTranslusent("block/glass_stained/" + color.getSerializedName() + "/framed", "block/glass_stained/" + color.getSerializedName() + "/framed_fancy-ctm"))
                    .next("streaks")
                    .next("rough")
                    .model(ModelTemplates.cubeCTMTranslusent("block/glass_stained/" + color.getSerializedName() + "/rough", "block/glass_stained/" + color.getSerializedName() + "/rough-ctm"))
                    .next("brick")
                    .model(ModelTemplates.cubeCTMTranslusent("block/glass_stained/" + color.getSerializedName() + "/brick", "block/glass_stained/" + color.getSerializedName() + "/brick-ctm"))
                    .build(b -> b.sound(SoundType.GLASS).explosionResistance(0.3F))
            ));

    public static Map<DyeColor, Map<String, BlockEntry<BlockCarvablePane>>> GLASSPANE_STAINED = Arrays.stream(DyeColor.values())
            .collect(Collectors.toMap(Function.identity(), color -> _FACTORY.newType(Material.GLASS, "glasspane_stained/" + color.getSerializedName(), BlockCarvablePane::new)
                    .addBlock(new ResourceLocation(color.getSerializedName() + "_stained_glasspane"))
                    .setGroupName(RegistrateLangProvider.toEnglishName(color.getSerializedName()) + " Stained Glasspane")
                    .initialProperties(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(color.getSerializedName() + "_stained_glass_pane")))
                    .addTag(Tags.Blocks.GLASS_PANES)
                    .addTag(BlockTags.create(new ResourceLocation("forge", "glass_pane/" + color.getSerializedName())))
                    .variation("panel")
                    .model(ModelTemplates.paneBlock("minecraft:block/" + color.getSerializedName() + "_stained_glass_pane_top"))
                    .itemModel((ctx, prov) -> prov.withExistingParent("item/" + prov.name(ctx::getEntry), new ResourceLocation("item/generated")).texture("layer0", "block/" + prov.name(ctx::getEntry).replaceFirst("pane", "")))
                    .next("framed")
                    .model(ModelTemplates.paneBlockCTM("minecraft:block/" + color.getSerializedName() + "_stained_glass_pane_top", "block/glass_stained/" + color.getSerializedName() + "/framed", "block/glass_stained/" + color.getSerializedName() + "/framed"))
                    .itemModel((ctx, prov) -> prov.withExistingParent("item/" + prov.name(ctx::getEntry), new ResourceLocation("item/generated")).texture("layer0", "block/" + prov.name(ctx::getEntry).replaceFirst("pane", "")))
                    .next("framed_fancy")
                    .model(ModelTemplates.paneBlockCTM("minecraft:block/" + color.getSerializedName() + "_stained_glass_pane_top", "block/glass_stained/" + color.getSerializedName() + "/framed", "block/glass_stained/" + color.getSerializedName() + "/framed_fancy"))
                    .itemModel((ctx, prov) -> prov.withExistingParent("item/" + prov.name(ctx::getEntry), new ResourceLocation("item/generated")).texture("layer0", "block/glass_stained/" + color.getSerializedName() + "/framed"))
                    .next("streaks")
                    .model(ModelTemplates.paneBlock("minecraft:block/" + color.getSerializedName() + "_stained_glass_pane_top"))
                    .itemModel((ctx, prov) -> prov.withExistingParent("item/" + prov.name(ctx::getEntry), new ResourceLocation("item/generated")).texture("layer0", "block/" + prov.name(ctx::getEntry).replaceFirst("pane", "")))
                    .next("rough")
                    .model(ModelTemplates.paneBlockCTM("minecraft:block/" + color.getSerializedName() + "_stained_glass_pane_top", "block/glass_stained/" + color.getSerializedName() + "/rough", "block/glass_stained/" + color.getSerializedName() + "/rough"))
                    .itemModel((ctx, prov) -> prov.withExistingParent("item/" + prov.name(ctx::getEntry), new ResourceLocation("item/generated")).texture("layer0", "block/" + prov.name(ctx::getEntry).replaceFirst("pane", "")))
                    .next("brick")
                    .model(ModelTemplates.paneBlockCTM("minecraft:block/" + color.getSerializedName() + "_stained_glass_pane_top", "block/glass_stained/" + color.getSerializedName() + "/brick", "block/glass_stained/" + color.getSerializedName() + "/brick"))
                    .itemModel((ctx, prov) -> prov.withExistingParent("item/" + prov.name(ctx::getEntry), new ResourceLocation("item/generated")).texture("layer0", "block/" + prov.name(ctx::getEntry).replaceFirst("pane", "")))
                    .build(b -> b.sound(SoundType.GLASS).explosionResistance(0.3F))
            ));

    public static final Map<String, BlockEntry<BlockCarvable>> NETHERBRICK = _FACTORY.newType(Material.STONE, "netherbrick")
            .addBlock(Blocks.NETHER_BRICKS)
            .applyTag(BlockTags.MINEABLE_WITH_PICKAXE)
            .initialProperties(() -> Blocks.NETHER_BRICKS)
            .variation("a1_netherbrick_brinstar")
            .next("a1_netherbrick_classicspatter")
            .next("a1_netherbrick_guts")
            .next("a1_netherbrick_gutsdark")
            .next("a1_netherbrick_gutssmall")
            .next("a1_netherbrick_lavabrinstar")
            .next("a1_netherbrick_lavabrown")
            .next("a1_netherbrick_lavaobsidian")
            .next("a1_netherbrick_lavastonedark")
            .next("a1_netherbrick_meat")
            .next("a1_netherbrick_meatred")
            .next("a1_netherbrick_meatredsmall")
            .next("a1_netherbrick_meatsmall")
            .next("a1_netherbrick_red")
            .next("a1_netherbrick_redsmall")
            .next("netherfancybricks")
            .build();

    public static final Map<String, BlockEntry<BlockCarvable>> NETHERRACK = _FACTORY.newType(Material.STONE, "netherrack")
            .addBlock(Blocks.NETHERRACK)
            .applyTag(BlockTags.MINEABLE_WITH_PICKAXE)
            .initialProperties(() -> Blocks.NETHERRACK)
            .variation("a1_netherrack_bloodgravel")
            .next("a1_netherrack_bloodrock")
            .next("a1_netherrack_bloodrockgrey")
            .next("a1_netherrack_brinstar")
            .next("a1_netherrack_brinstarshale")
            .next("a1_netherrack_classic")
            .next("a1_netherrack_classicspatter")
            .next("a1_netherrack_guts")
            .next("a1_netherrack_gutsdark")
            .next("a1_netherrack_meat")
            .next("a1_netherrack_meatred")
            .next("a1_netherrack_meatrock")
            .next("a1_netherrack_red")
            .next("a1_netherrack_wells")
            .build();


    public static final Map<String, BlockEntry<BlockCarvablePane>> IRONPANE = _FACTORY.newType(Material.GLASS, "ironpane", BlockCarvablePane::new)
            .setGroupName("Iron Bars")
            .addBlock(Blocks.IRON_BARS)
            .initialProperties(() -> Blocks.IRON_BARS)
            .applyTag(BlockTags.MINEABLE_WITH_PICKAXE)
            .applyTag(BlockTags.NEEDS_IRON_TOOL)
            .variation("borderless")
            .model(ModelTemplates.bars("minecraft:block/iron_bars", "block/ironpane/borderless-top", "block/ironpane/borderless-side"))
            .itemModel((ctx, prov) -> prov.withExistingParent("item/" + prov.name(ctx::getEntry), new ResourceLocation("item/generated")).texture("layer0", "block/" + prov.name(ctx::getEntry)))
            .next("borderless-topper")
            .model(ModelTemplates.bars("block/ironpane/borderless-topper", "block/ironpane/borderless-topper-top", "block/ironpane/borderless-topper-side"))
            .itemModel((ctx, prov) -> prov.withExistingParent("item/" + prov.name(ctx::getEntry), new ResourceLocation("item/generated")).texture("layer0", "block/" + prov.name(ctx::getEntry)))
            .next("barbedwire")
            .model(ModelTemplates.bars("block/ironpane/barbedwire", "block/ironpane/barbedwire-top", "block/ironpane/barbedwire-side"))
            .itemModel((ctx, prov) -> prov.withExistingParent("item/" + prov.name(ctx::getEntry), new ResourceLocation("item/generated")).texture("layer0", "block/" + prov.name(ctx::getEntry)))
            .next("cage")
            .model(ModelTemplates.bars("block/ironpane/cage", "block/ironpane/cage-top", "block/ironpane/cage-top"))
            .itemModel((ctx, prov) -> prov.withExistingParent("item/" + prov.name(ctx::getEntry), new ResourceLocation("item/generated")).texture("layer0", "block/" + prov.name(ctx::getEntry)))
            .next("thickgrid")
            .model(ModelTemplates.bars())
            .itemModel((ctx, prov) -> prov.withExistingParent("item/" + prov.name(ctx::getEntry), new ResourceLocation("item/generated")).texture("layer0", "block/" + prov.name(ctx::getEntry)))
            .next("thingrid")
            .model(ModelTemplates.bars("block/ironpane/thingrid", "block/ironpane/thingrid-top", "block/ironpane/thingrid-top"))
            .itemModel((ctx, prov) -> prov.withExistingParent("item/" + prov.name(ctx::getEntry), new ResourceLocation("item/generated")).texture("layer0", "block/" + prov.name(ctx::getEntry)))
            .next("ornatesteel")
            .model(ModelTemplates.bars("block/ironpane/ornatesteel", "block/ironpane/ornatesteel-top", "block/ironpane/ornatesteel-top"))
            .itemModel((ctx, prov) -> prov.withExistingParent("item/" + prov.name(ctx::getEntry), new ResourceLocation("item/generated")).texture("layer0", "block/" + prov.name(ctx::getEntry)))
            .next("bars")
            .model(ModelTemplates.bars("block/ironpane/bars", "block/ironpane/bars-top", "block/ironpane/bars-side"))
            .itemModel((ctx, prov) -> prov.withExistingParent("item/" + prov.name(ctx::getEntry), new ResourceLocation("item/generated")).texture("layer0", "block/" + prov.name(ctx::getEntry)))
            .next("spikes")
            .model(ModelTemplates.bars("block/ironpane/spikes", "block/ironpane/spikes-top", "block/ironpane/spikes-side"))
            .itemModel((ctx, prov) -> prov.withExistingParent("item/" + prov.name(ctx::getEntry), new ResourceLocation("item/generated")).texture("layer0", "block/" + prov.name(ctx::getEntry)))
            .next("classic")
            .model(ModelTemplates.bars())
            .itemModel((ctx, prov) -> prov.withExistingParent("item/" + prov.name(ctx::getEntry), new ResourceLocation("item/generated")).texture("layer0", "block/" + prov.name(ctx::getEntry)))
            .next("classicnew")
            .model(ModelTemplates.bars("block/ironpane/classicnew", "block/ironpane/classic", "block/ironpane/classic"))
            .itemModel((ctx, prov) -> prov.withExistingParent("item/" + prov.name(ctx::getEntry), new ResourceLocation("item/generated")).texture("layer0", "block/" + prov.name(ctx::getEntry)))
            .next("fence")
            .model(ModelTemplates.bars("block/ironpane/fence", "block/ironpane/bars-top", "block/ironpane/bars-top"))
            .itemModel((ctx, prov) -> prov.withExistingParent("item/" + prov.name(ctx::getEntry), new ResourceLocation("item/generated")).texture("layer0", "block/" + prov.name(ctx::getEntry)))
            .next("modern")
            .model(ModelTemplates.bars("block/ironpane/modern", "block/ironpane/modern-top", "block/ironpane/modern-top"))
            .itemModel((ctx, prov) -> prov.withExistingParent("item/" + prov.name(ctx::getEntry), new ResourceLocation("item/generated")).texture("layer0", "block/" + prov.name(ctx::getEntry)))
            .build();

    public static final Map<String, BlockEntry<BlockCarvable>> OBSIDIAN = _FACTORY.newType(Material.STONE, "obsidian")
            .addTag(Tags.Blocks.OBSIDIAN)
            .applyTag(BlockTags.DRAGON_IMMUNE)
            .applyTag(BlockTags.MINEABLE_WITH_PICKAXE)
            .applyTag(BlockTags.NEEDS_DIAMOND_TOOL)
            .variation("pillar")
                .model(ModelTemplates.cubeColumn())
            .next("pillar-quartz")
                .model(ModelTemplates.cubeColumn())
            .next("chiseled")
                .model(ModelTemplates.cubeColumn())
            .next("panel_shiny")
            .next("panel")
            .next("chunks")
            .next("growth")
            .next("crystal")
            .next("map-a")
            .next("map-b")
            .next("panel_light")
            .next("blocks")
            .next("tiles")
            .next("greek")
                .model(ModelTemplates.cubeColumn())
            .next("crate")
                .model(ModelTemplates.cubeBottomTop())
            .build(b -> b.strength(50.0F, 2000.0F).sound(SoundType.STONE));

    public static final Map<String, BlockEntry<BlockCarvable>> PAPER = _FACTORY.newType(Material.PLANT, "paper")
            .recipe((prov, block) -> new ShapedRecipeBuilder(block, 32)
                    .pattern("ppp").pattern("psp").pattern("ppp")
                    .define('p', Items.PAPER)
                    .define('s', Tags.Items.RODS_WOODEN)
                    .unlockedBy("has_stick", prov.has(Tags.Items.RODS_WOODEN))
                    .save(prov))
            .variation("box")
            .next("throughmiddle")
            .next("cross")
            .next("sixsections")
            .next("vertical")
            .next("horizontal")
            .next("floral")
            .next("plain")
            .next("door")
            .build(b -> b.strength(1.5F, 0.0F).sound(SoundType.GRASS));

    public static final TagKey<Block> TEMPLE1 = BlockTags.create(new ResourceLocation(Reference.MOD_ID, "temple"));

    public static final Map<String, BlockEntry<BlockCarvable>> TEMPLE = _FACTORY.newType(Material.STONE, "temple")
            .setGroup(TEMPLE1)
            .applyTag(BlockTags.MINEABLE_WITH_PICKAXE)
            .applyTag(BlockTags.NEEDS_STONE_TOOL)
            .recipe((prov, block) -> new ShapedRecipeBuilder(block, 32)
                    .pattern("SSS").pattern("SXS").pattern("SSS")
                    .define('S', Tags.Items.STONE)
                    .define('X', Tags.Items.DYES_CYAN)
                    .unlockedBy("has_dye", prov.has(Tags.Items.DYES_CYAN))
                    .save(prov))
            .variation("cobble") //TODO fix ctm and model
            .model(ModelTemplates.cubeEldritch())
            .next("ornate")
            .model(ModelTemplates.cubeEldritch())
            .next("plate")
            .model(ModelTemplates.cubeEldritch())
            .next("plate_cracked") //TODO fix ctm and model
            .model(ModelTemplates.cubeEldritch())
            .next("bricks")
            .model(ModelTemplates.cubeEldritch())
            .next("large_bricks")
            .model(ModelTemplates.cubeEldritch())
            .next("weared_bricks")
            .model(ModelTemplates.cubeEldritch())
            .next("disarray_bricks")
            .model(ModelTemplates.cubeEldritch())
            .next("column")
            .model(ModelTemplates.columnEldritch("temple"))
            .next("stand")
            .model(ModelTemplates.columnEldritch("temple"))
            .next("tiles")
            .model(ModelTemplates.cubeEldritch())
            .next("smalltiles")
            .model(ModelTemplates.cubeEldritch())
            .next("tiles_light")
            .model(ModelTemplates.cubeEldritch())
            .next("smalltiles_light")
            .model(ModelTemplates.cubeEldritch())
            .next("stand_creeper")
            .model(ModelTemplates.columnEldritch("temple"))
            .next("stand_mosaic")
            .model(ModelTemplates.columnEldritch("temple"))
            .build(b -> b.strength(1.5F).explosionResistance(10.0F).sound(SoundType.STONE));

    public static final Map<String, BlockEntry<BlockCarvable>> TEMPLE_MOSSY = _FACTORY.newType(Material.STONE, "templemossy")
            .setGroup(TEMPLE1)
            .setGroupName("")
            .applyTag(BlockTags.MINEABLE_WITH_PICKAXE)
            .applyTag(BlockTags.NEEDS_STONE_TOOL)
            .variation("cobble") //TODO fix ctm and model
            .model(ModelTemplates.cubeEldritch())
            .next("ornate")
            .model(ModelTemplates.cubeEldritch())
            .next("plate")
            .model(ModelTemplates.cubeEldritch())
            .next("plate_cracked") //TODO fix ctm and model
            .model(ModelTemplates.cubeEldritch())
            .next("bricks")
            .model(ModelTemplates.cubeEldritch())
            .next("large_bricks")
            .model(ModelTemplates.cubeEldritch())
            .next("weared_bricks")
            .model(ModelTemplates.cubeEldritch())
            .next("disarray_bricks")
            .model(ModelTemplates.cubeEldritch())
            .next("column")
            .model(ModelTemplates.columnEldritch("temple"))
            .next("stand")
            .model(ModelTemplates.columnEldritch("temple"))
            .next("tiles")
            .model(ModelTemplates.cubeEldritch())
            .next("smalltiles")
            .model(ModelTemplates.cubeEldritch())
            .next("tiles_light")
            .model(ModelTemplates.cubeEldritch())
            .next("smalltiles_light")
            .model(ModelTemplates.cubeEldritch())
            .next("stand_creeper")
            .model(ModelTemplates.columnEldritch("temple"))
            .next("stand_mosaic")
            .model(ModelTemplates.columnEldritch("temple"))
            .build(b -> b.strength(1.5F).explosionResistance(10.0F).sound(SoundType.STONE));

    public static final Map<String, BlockEntry<BlockCarvable>> TYRIAN = _FACTORY.newType(Material.METAL, "tyrian")
            .applyTag(BlockTags.MINEABLE_WITH_PICKAXE)
            .applyTag(BlockTags.NEEDS_STONE_TOOL)
            .initialProperties(() -> Blocks.IRON_BLOCK)
            .color(MaterialColor.TERRACOTTA_CYAN)
            .variation("shining")
            .recipe((prov, block) -> new ShapedRecipeBuilder(block, 32)
                    .pattern("SSS").pattern("SXS").pattern("SSS")
                    .define('S', Tags.Items.STONE)
                    .define('X', Tags.Items.INGOTS_IRON)
                    .unlockedBy("has_iron", prov.has(Tags.Items.INGOTS_IRON))
                    .save(prov))
            .next("tyrian")
            .next("chaotic")
            .next("softplate")
            .next("rust")
            .next("elaborate")
            .next("routes")
            .next("platform")
            .next("platetiles")
            .next("diagonal")
            .next("dent")
            .next("blueplating")
            .next("black")
            .next("black2")
            .next("opening")
            .next("plate") // FIXME temporary texture
            .build();

	public static void init() {}
}
