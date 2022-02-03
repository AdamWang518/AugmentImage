/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.ar.sceneform.samples.augmentedimage;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.ar.core.Anchor;
import com.google.ar.core.AugmentedImage;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.Node;
import com.google.ar.sceneform.math.Quaternion;
import com.google.ar.sceneform.math.Vector3;
import com.google.ar.sceneform.rendering.FixedWidthViewSizer;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.rendering.ViewRenderable;
import com.google.ar.sceneform.samples.ModelAction.ModelContent;
import com.google.ar.sceneform.samples.ModelAction.ModelIntro;
import com.google.ar.sceneform.samples.ModelAction.ModelList;

import java.util.concurrent.CompletableFuture;

/**
 * Node for rendering an augmented image. The image is framed by placing the virtual picture frame
 * at the corners of the augmented image trackable.
 */
@SuppressWarnings({"AndroidApiChecker"})
public class AugmentedImageNode extends AnchorNode {


  private static CompletableFuture<ModelRenderable> ulCorner;
  private static CompletableFuture<ModelRenderable> urCorner;
  private static CompletableFuture<ModelRenderable> lrCorner;
  private static CompletableFuture<ModelRenderable> llCorner;
  private static CompletableFuture<ModelRenderable> house;
  private static CompletableFuture<ViewRenderable> CGUImageRenderable;
  private static CompletableFuture<ViewRenderable> CGUListRebderable;
  private static CompletableFuture<ViewRenderable> CGUIndustryRebderable;
  private static CompletableFuture<ViewRenderable> MedicalList;
    private static CompletableFuture<ViewRenderable> MedicalChildList;
  private static CompletableFuture<ViewRenderable> Content;
  private static CompletableFuture<ViewRenderable> ListButtonRebderable;
  private static CompletableFuture<ViewRenderable> CGUMedicalRebderable;
  private static CompletableFuture<ViewRenderable> CGUManageRebderable;
  private View ListLayout=null;
  private View InfoLayout = null;
  private Anchor anchor = null;
  public AugmentedImageNode(Context context) {
    // Upon construction, start loading the models for the corners of the frame.
    if (ulCorner == null) {
      ulCorner =
          ModelRenderable.builder()
              .setSource(context, Uri.parse("models/frame_upper_left.sfb"))
              .build();
      urCorner =
          ModelRenderable.builder()
              .setSource(context, Uri.parse("models/frame_upper_right.sfb"))
              .build();
      llCorner =
          ModelRenderable.builder()
              .setSource(context, Uri.parse("models/frame_lower_left.sfb"))
              .build();
      lrCorner =
          ModelRenderable.builder()
              .setSource(context, Uri.parse("models/frame_lower_right.sfb"))
              .build();
      house =
              ModelRenderable.builder()
                      .setSource(context, Uri.parse("models/house.sfb"))
                      .build();

    }

//    CGUImageRenderable=ViewRenderable.builder().setSizer(new FixedWidthViewSizer(0.5f)).setView(context,R.layout.cguimage).build();
//    CGUListRebderable=ViewRenderable.builder().setSizer(new FixedWidthViewSizer(0.25f)).setView(context,R.layout.cgulist).build();
//    CGUImageRenderable.thenAccept( (renderable) -> {
//          InfoLayout=renderable.getView();
//    });
//    CGUListRebderable.thenAccept(
//            (renderable) -> {
//                ListLayout=renderable.getView();
//                ModelList modelList = new ModelList(context,ListLayout,InfoLayout);
//                modelList.setListView((department_name));
//            });

      CGUIndustryRebderable=ViewRenderable.builder().setSizer(new FixedWidthViewSizer(0.5f)).setView(context,R.layout.industry_cgu).build();
      CGUMedicalRebderable=ViewRenderable.builder().setSizer(new FixedWidthViewSizer(0.5f)).setView(context,R.layout.medical_cgu).build();
      CGUManageRebderable=ViewRenderable.builder().setSizer(new FixedWidthViewSizer(0.5f)).setView(context,R.layout.manage_cgu).build();
      MedicalList=ViewRenderable.builder().setSizer(new FixedWidthViewSizer(0.1f)).setView(context,R.layout.medical_list).build();
      MedicalChildList=ViewRenderable.builder().setSizer(new FixedWidthViewSizer(0.1f)).setView(context,R.layout.medical_child_list).build();
      Content=ViewRenderable.builder().setSizer(new FixedWidthViewSizer(0.1f)).setView(context,R.layout.content).build();
      ListButtonRebderable=ViewRenderable.builder().setSizer(new FixedWidthViewSizer(0.05f)).setView(context,R.layout.listbutton).build();
      CGUIndustryRebderable.thenAccept(
                (renderable) -> {
                   View view = renderable.getView();
                    ModelIntro intro = new ModelIntro("industry",context,view);
                });
      ListButtonRebderable.thenAccept(
              (renderable) -> {
                  View view = renderable.getView();
                  ModelIntro intro = new ModelIntro("List",context,view);
              });
      CGUMedicalRebderable.thenAccept(
              (renderable) -> {
                  View view = renderable.getView();
                  ModelIntro intro = new ModelIntro("medical",context,view);
              });
      CGUManageRebderable.thenAccept(
              (renderable) -> {
                  View view = renderable.getView();
                  ModelIntro intro = new ModelIntro("manage",context,view);
              });
      MedicalList.thenAccept(
              (renderable) -> {
                  Content.thenAccept(
                          (ContentRenderable) -> {
                              MedicalChildList.thenAccept((ChildRenderable) -> {
                                  View Contentview = ContentRenderable.getView();
                                  View view = renderable.getView();
                                  View childview=ChildRenderable.getView();
                                  ModelList childList = new ModelList(context,childview,Contentview);
                                  ModelList modelList = new ModelList(context,view,Contentview);
                                  ModelContent intro = new ModelContent(context,Contentview,view);


                              });
                          });
              });
//      Content.thenAccept(
//              (ContentRenderable) -> {
//                  View Contentview = ContentRenderable.getView();
//                  ModelIntro intro = new ModelIntro("Content",context,Contentview);
//
//              });


  }






  @SuppressWarnings({"AndroidApiChecker", "FutureReturnValueIgnored"})
  public void setImage(AugmentedImage image) {


    // If any of the models are not loaded, then recurse when all are loaded.
    if (!ulCorner.isDone() || !urCorner.isDone() || !llCorner.isDone() || !lrCorner.isDone()) {
      CompletableFuture.allOf(ulCorner, urCorner, llCorner, lrCorner)
          .thenAccept((Void aVoid) -> setImage(image))
          .exceptionally(
              throwable -> {
                return null;
              });
    }
    this.anchor = image.createAnchor(image.getCenterPose());
    // Set the anchor based on the center of the image.
    setAnchor(this.anchor);
    setModelRenderable(ListButtonRebderable,0f,0.1f, -1f * 0.13f);
    setModelRenderable(Content,-0.085f,0.1f, -1f * 0.13f);
    setModelRenderable(MedicalList,0.085f,0.1f, -1f * 0.13f);
    setModelRenderable(MedicalChildList,0.2f,0.1f, -1f * 0.13f);
    //setModelRenderable(CGUManageRebderable,-3f * image.getExtentX(), 0f, 0.5f * image.getExtentZ());//x是左右，Y
    //setModelRenderable(CGUMedicalRebderable,0f, 0.1f, -1f * 0.13f);
    // setModelRenderable2(house,0,0,0);
    //setModelRenderable(CGUIndustryRebderable,3f * image.getExtentX(), 0f, 0.5f * image.getExtentZ());
    Log.d("Sizelog", String.valueOf(image.getExtentZ()));


  }

  private void setModelRenderable(CompletableFuture<ViewRenderable> renderable,float x,float y,float z){
      Node cornerNode;
      Vector3 localPosition = new Vector3();
      localPosition.set(x,y,z);
      cornerNode = new Node();
      cornerNode.setParent(this);
      cornerNode.setLocalPosition(localPosition);
      cornerNode.setLookDirection(Vector3.forward());

      cornerNode.setRenderable(renderable.getNow(null));
  }

    private void setModelRenderable2(CompletableFuture<ModelRenderable> renderable,float x,float y,float z){
        Node cornerNode;
        Quaternion conerQuaternion=new Quaternion();
        conerQuaternion.axisAngle(new Vector3(),90);
        Vector3 localPosition = new Vector3();
        localPosition.set(x,y,z);
        cornerNode = new Node();
        cornerNode.setParent(this);
        cornerNode.setLocalPosition(localPosition);
        cornerNode.setLocalRotation (conerQuaternion);
        cornerNode.setLocalScale(new Vector3(0.1f, 0.1f, 0.1f));
        cornerNode.setRenderable(renderable.getNow(null));
    }

  public  void removeAnchor(){
     this.anchor.detach();

  }

}
