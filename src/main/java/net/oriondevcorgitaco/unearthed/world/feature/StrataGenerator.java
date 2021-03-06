package net.oriondevcorgitaco.unearthed.world.feature;

import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.oriondevcorgitaco.unearthed.block.BlockGeneratorReference;
import net.oriondevcorgitaco.unearthed.block.BlockGeneratorReference;
import net.oriondevcorgitaco.unearthed.util.RegistrationHelper;
import net.oriondevcorgitaco.unearthed.util.noise.FastNoise;

import java.util.Random;

public class StrataGenerator extends Feature<NoFeatureConfig> {
    public static final Feature<NoFeatureConfig> UNDERGROUND_STONE = RegistrationHelper.registerFeature("strata_gen1", new StrataGenerator(NoFeatureConfig.field_236558_a_));

    public StrataGenerator(Codec<NoFeatureConfig> configCodec) {
        super(configCodec);
    }

    FastNoise fastNoise3D = null;
    FastNoise fastNoise3D2 = null;

    @Override
    public boolean generate(ISeedReader world, ChunkGenerator generator, Random random, BlockPos pos, NoFeatureConfig config) {
        setSeed(world.getSeed());

        BlockPos.Mutable mutable = new BlockPos.Mutable();
        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                mutable.setPos(pos.getX() + x, 0, pos.getZ() + z);
                int topY = world.getHeight(Heightmap.Type.OCEAN_FLOOR_WG, mutable.getX(), mutable.getZ());

                for (int y = 0; y < topY; y++) {
                    //Noise range is between -1 and 1.
                    double noise3D = fastNoise3D.GetNoise(mutable.getX(), mutable.getY(), mutable.getZ());

                    if (world.getBlockState(mutable).getBlock().isIn(BlockTags.BASE_STONE_OVERWORLD)) {
                        if (world.getBiome(mutable).getCategory() == Biome.Category.ICY) {
                            if (noise3D > 0.5)
                                world.setBlockState(mutable, BlockGeneratorReference.RHYOLITE.getBaseBlock().getDefaultState(), 2);
                            else if (noise3D > 0.0)
                                world.setBlockState(mutable, Blocks.DIORITE.getDefaultState(), 2);
                            else if (noise3D > -0.5)
                                world.setBlockState(mutable, Blocks.ANDESITE.getDefaultState(), 2);
                            else if (noise3D > -0.7)
                                world.setBlockState(mutable, BlockGeneratorReference.LIMESTONE.getBaseBlock().getDefaultState(), 2);
                            else
                                world.setBlockState(mutable, BlockGeneratorReference.GABBRO.getBaseBlock().getDefaultState(), 2);

                        } else if (world.getBiome(mutable).getCategory() == Biome.Category.MESA) {
                            if (noise3D > 0.5)
                                world.setBlockState(mutable, Blocks.RED_TERRACOTTA.getDefaultState(), 2);
                            else if (noise3D > 0.0)
                                world.setBlockState(mutable, Blocks.BLACK_TERRACOTTA.getDefaultState(), 2);
                            else if (noise3D > -0.5)
                                world.setBlockState(mutable, Blocks.YELLOW_TERRACOTTA.getDefaultState(), 2);
                            else if (noise3D > -0.6)
                                world.setBlockState(mutable, Blocks.WHITE_TERRACOTTA.getDefaultState(), 2);
                            else if (noise3D > -0.7)
                                world.setBlockState(mutable, Blocks.GRAY_TERRACOTTA.getDefaultState(), 2);
                            else if (noise3D > -0.8)
                                world.setBlockState(mutable, Blocks.LIGHT_GRAY_TERRACOTTA.getDefaultState(), 2);
                            else if (noise3D > -0.9)
                                world.setBlockState(mutable, Blocks.TERRACOTTA.getDefaultState(), 2);
                            else
                                world.setBlockState(mutable, Blocks.ORANGE_TERRACOTTA.getDefaultState(), 2);

                        } else if (world.getBiome(mutable).getCategory() == Biome.Category.EXTREME_HILLS) {
                            if (noise3D > 0.5)
                                world.setBlockState(mutable, BlockGeneratorReference.RHYOLITE.getBaseBlock().getDefaultState(), 2);
                            else if (noise3D > 0.0)
                                world.setBlockState(mutable, Blocks.GRANITE.getDefaultState(), 2);
                            else if (noise3D > -0.5)
                                world.setBlockState(mutable, Blocks.ANDESITE.getDefaultState(), 2);
                            else if (noise3D > -0.7)
                                world.setBlockState(mutable, BlockGeneratorReference.RHYOLITE.getBaseBlock().getDefaultState(), 2);
                            else if (noise3D > -0.9)
                                world.setBlockState(mutable, BlockGeneratorReference.RHYOLITE.getBaseBlock().getDefaultState(), 2);
                            else
                                world.setBlockState(mutable, BlockGeneratorReference.KIMBERLITE.getBaseBlock().getDefaultState(), 2);


                        } else if (world.getBiome(mutable).getCategory() == Biome.Category.EXTREME_HILLS) {
                            if (noise3D > 0.5)
                                world.setBlockState(mutable, BlockGeneratorReference.RHYOLITE.getBaseBlock().getDefaultState(), 2);
                            else if (noise3D > 0.0)
                                world.setBlockState(mutable, Blocks.DIORITE.getDefaultState(), 2);
                            else if (noise3D > -0.5)
                                world.setBlockState(mutable, Blocks.ANDESITE.getDefaultState(), 2);
                            else if (noise3D > -0.7)
                                world.setBlockState(mutable, BlockGeneratorReference.PILLOW_BASALT.getBaseBlock().getDefaultState(), 2);
                            else if (noise3D > -0.9)
                                world.setBlockState(mutable, BlockGeneratorReference.KIMBERLITE.getBaseBlock().getDefaultState(), 2);
                            else
                                world.setBlockState(mutable, BlockGeneratorReference.KIMBERLITE.getBaseBlock().getDefaultState(), 2);

                        } else if (world.getBiome(mutable).getCategory() == Biome.Category.OCEAN) {
                            if (noise3D > 0.5)
                                world.setBlockState(mutable, BlockGeneratorReference.PUMICE.getBaseBlock().getDefaultState(), 2);
                            else if (noise3D > 0.0)
                                world.setBlockState(mutable, BlockGeneratorReference.GABBRO.getBaseBlock().getDefaultState(), 2);
                            else if (noise3D > -0.5)
                                world.setBlockState(mutable, BlockGeneratorReference.GABBRO.getBaseBlock().getDefaultState(), 2);
                            else
                                world.setBlockState(mutable, BlockGeneratorReference.PILLOW_BASALT.getBaseBlock().getDefaultState(), 2);

                        } else if (world.getBiome(mutable).getCategory() == Biome.Category.DESERT) {
                            if (noise3D > 0.5)
                                world.setBlockState(mutable, Blocks.SANDSTONE.getDefaultState(), 2);
                            else if (noise3D > 0.0)
                                world.setBlockState(mutable, BlockGeneratorReference.CONGLOMERATE.getBaseBlock().getDefaultState(), 2);
                            else if (noise3D > -0.5)
                                world.setBlockState(mutable, BlockGeneratorReference.LIMESTONE.getBaseBlock().getDefaultState(), 2);
                            else if (noise3D > -0.7)
                                world.setBlockState(mutable, BlockGeneratorReference.LIMESTONE.getBaseBlock().getDefaultState(), 2);
                            else
                                world.setBlockState(mutable, BlockGeneratorReference.SILTSTONE.getBaseBlock().getDefaultState(), 2);

                        } else if (world.getBiome(mutable).getCategory() == Biome.Category.SWAMP) {
                            if (noise3D > 0.5)
                                world.setBlockState(mutable, BlockGeneratorReference.SILTSTONE.getBaseBlock().getDefaultState(), 2);
                            else if (noise3D > 0.0)
                                world.setBlockState(mutable, BlockGeneratorReference.SILTSTONE.getBaseBlock().getDefaultState(), 2);
                            else if (noise3D > -0.5)
                                world.setBlockState(mutable, BlockGeneratorReference.LIGNITE.getBaseBlock().getDefaultState(), 2);
                            else if (noise3D > -0.7)
                                world.setBlockState(mutable, BlockGeneratorReference.LIGNITE.getBaseBlock().getDefaultState(), 2);
                            else
                                world.setBlockState(mutable, BlockGeneratorReference.MUDSTONE.getBaseBlock().getDefaultState(), 2);

                        } else if (world.getBiome(mutable).getCategory() == Biome.Category.FOREST) {
                            if (noise3D > 0.5)
                                world.setBlockState(mutable, BlockGeneratorReference.MARBLE.getBaseBlock().getDefaultState(), 2);
                            else if (noise3D > 0.0)
                                world.setBlockState(mutable, BlockGeneratorReference.MARBLE.getBaseBlock().getDefaultState(), 2);
                            else if (noise3D > -0.5)
                                world.setBlockState(mutable, BlockGeneratorReference.SCHIST.getBaseBlock().getDefaultState(), 2);
                            else if (noise3D > -0.7)
                                world.setBlockState(mutable, BlockGeneratorReference.PHYLLITE.getBaseBlock().getDefaultState(), 2);
                            else if (noise3D > -0.9)
                                world.setBlockState(mutable, BlockGeneratorReference.QUARTZITE.getBaseBlock().getDefaultState(), 2);
                            else
                                world.setBlockState(mutable, BlockGeneratorReference.QUARTZITE.getBaseBlock().getDefaultState(), 2);

                        } else {
                            double noise3D2 = fastNoise3D2.GetNoise(mutable.getX(), mutable.getY(), mutable.getZ());

                            if (noise3D2 > 0.8)
                                world.setBlockState(mutable, BlockGeneratorReference.LIMESTONE.getBaseBlock().getDefaultState(), 2);
                            else if (noise3D2 > 0.6)
                                world.setBlockState(mutable, BlockGeneratorReference.MARBLE.getBaseBlock().getDefaultState(), 2);
                            else if (noise3D2 > 0.4)
                                world.setBlockState(mutable, BlockGeneratorReference.CONGLOMERATE.getBaseBlock().getDefaultState(), 2);
                            else if (noise3D2 > 0)
                                world.setBlockState(mutable, BlockGeneratorReference.QUARTZITE.getBaseBlock().getDefaultState(), 2);
                            else if (noise3D2 > -0.2)
                                world.setBlockState(mutable, BlockGeneratorReference.RHYOLITE.getBaseBlock().getDefaultState(), 2);
                            else if (noise3D2 > -0.4)
                                world.setBlockState(mutable, BlockGeneratorReference.CONGLOMERATE.getBaseBlock().getDefaultState(), 2);
                            else if (noise3D2 > -0.6)
                                world.setBlockState(mutable, BlockGeneratorReference.GABBRO.getBaseBlock().getDefaultState(), 2);
                            else if (noise3D2 > -0.8)
                                world.setBlockState(mutable, BlockGeneratorReference.SILTSTONE.getBaseBlock().getDefaultState(), 2);
                            else
                                world.setBlockState(mutable, Blocks.ANDESITE.getDefaultState(), 2);
                        }
                    }
                    mutable.move(Direction.UP);
                }
            }
        }
        return true;
    }


    private void setSeed(long seed) {
        if (fastNoise3D == null) {
            fastNoise3D = new FastNoise((int) seed);
            fastNoise3D.SetNoiseType(FastNoise.NoiseType.Simplex);
            fastNoise3D.SetFrequency(0.004F);
        }

        if (fastNoise3D2 == null) {
            fastNoise3D2 = new FastNoise((int) seed);
            fastNoise3D2.SetNoiseType(FastNoise.NoiseType.Simplex);
            fastNoise3D2.SetFrequency(0.004F);
        }
    }
}
