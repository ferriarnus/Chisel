package team.chisel.client.render.type;

//@TextureType("SCTM")
public class BlockRenderTypeSimpleCTM { //extends TextureTypeCTM {
//    @Override
//    public ICTMTexture<? extends TextureTypeCTM> makeTexture(TextureInfo info) {
//        return new ChiselTextureSimpleCTM(this, info);
//    }
//
//    @Override
//    public TextureContextCTM getBlockRenderContext(BlockState state, IBlockAccess world, BlockPos pos, ICTMTexture<?> tex) {
//        return new TextureContextCTM(state, world, pos, (TextureCTM<?>) tex) {
//
//            @Override
//            protected CTMLogic createCTM(BlockState state) {
//                CTMLogic ctm = super.createCTM(state);
//
//                ctm.disableObscuredFaceCheck = Optional.of(true);
//
//                return ctm;
//            }
//        };
//    }
//
//    @Override
//    public int getQuadsPerSide() {
//        return 1;
//    }
//
//    @Override
//    public int requiredTextures() {
//        return 1;
//    }
}
