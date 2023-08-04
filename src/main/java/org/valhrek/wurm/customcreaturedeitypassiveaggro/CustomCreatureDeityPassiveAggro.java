package org.valhrek.wurm.customcreaturedeitypassiveaggro;

import javassist.CannotCompileException;
import javassist.CtClass;
import javassist.NotFoundException;
import javassist.expr.ExprEditor;
import javassist.expr.MethodCall;
import org.gotti.wurmunlimited.modloader.classhooks.HookManager;
import org.gotti.wurmunlimited.modloader.interfaces.PreInitable;
import org.gotti.wurmunlimited.modloader.interfaces.WurmServerMod;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CustomCreatureDeityPassiveAggro implements WurmServerMod, PreInitable {

    private static final Logger logger = Logger.getLogger(CustomCreatureDeityPassiveAggro.class.getName());

    @Override
    public void preInit() {
        try {
            String code = "$_ = !this.isHerd() && $proceed($$);";
            CtClass ctCreature = HookManager.getInstance().getClassPool().get(
                    "com.wurmonline.server.creatures.Creature");
            ctCreature.getDeclaredMethod("getAttitude").instrument(new ExprEditor() {
                public void edit(MethodCall m) throws CannotCompileException {
                    if ( m.getMethodName().equals("isBefriendMonster") || m.getMethodName().equals("isBefriendCreature")) {
                        logger.info("Added custom aggro check for " + m.getMethodName());
                        m.replace(code);
                    }
                }
            });
        } catch (NotFoundException | CannotCompileException e) {
            e.printStackTrace();
            logger.log(Level.SEVERE, "failed to update Creature.getAttitude for isBefriendCreature/isBefriendMonster. ", e);
        }
    }
    @Override
    public String getVersion(){
        return "1.0";
    }
}
